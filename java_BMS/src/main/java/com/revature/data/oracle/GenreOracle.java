package com.revature.data.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.beans.Book;
import com.revature.beans.Genre;
import com.revature.data.GenreDAO;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.LogUtil;

public class GenreOracle implements GenreDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private static Logger log = Logger.getLogger(GenreOracle.class);

	@Override
	public Integer addGenre(Genre g) {
		// We want to know what the key is
		Integer key = null;
		log.trace("Inserting a genre into the database.");
		Connection conn = cu.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into genre(genre) values(?)";
			String[] keys = { "id" };
			PreparedStatement stmt = conn.prepareStatement(sql, keys);
			stmt.setString(1, g.getGenre());
			int number = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (number != 1) {
				log.warn("Insert failed");
				conn.rollback();
			} else {
				log.trace("Insert succeeded!");
				if (rs.next()) {
					key = rs.getInt(1);
					g.setId(key);
					conn.commit();
				} else {
					log.warn("genre not created");
					conn.rollback();
				}
			}
		} catch (SQLException e) {
			LogUtil.rollback(e, conn, GenreOracle.class);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				LogUtil.logException(e, GenreOracle.class);
			}
		}
		return key;
	}

	@Override
	public Genre getGenre(Integer id) {
		log.trace("Attempting to find genre with id = " + id);
		Genre g = null;
		String sql = "select id, genre from genre where id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				log.trace("Found genre: " + rs.getString("genre"));
				g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenre(rs.getString("genre"));
			}
		} catch (SQLException e) {
			LogUtil.logException(e, GenreOracle.class);
		}
		log.trace("getGenre returning " + g);
		return g;
	}

	@Override
	public Genre getGenreByGenre(String genre) {
		log.trace("Attempting to find genre with genre = " + genre);
		Genre g = null;
		String sql = "select id, genre from genre where genre = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, genre);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				log.trace("Found genre: " + rs.getString("genre"));
				g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenre(rs.getString("genre"));
			}
		} catch (SQLException e) {
			LogUtil.logException(e, GenreOracle.class);
		}
		log.trace("getGenre returning " + g);
		return g;
	}

	@Override
	public Set<Genre> getGenres() {
		log.trace("Trying to retrieve all genres");
		Set<Genre> genres = new HashSet<Genre>();
		String sql = "select id, genre from genre";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				log.trace("Found genre: " + rs.getString("genre"));
				Genre g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenre(rs.getString("genre"));
				genres.add(g);
			}
		} catch (SQLException e) {
			LogUtil.logException(e, GenreOracle.class);
		}
		log.trace("getGenre returning " + genres);
		return genres;
	}

	@Override
	public Set<Genre> getGenresByBook(Book b) {
		log.trace("Trying to retrieve all genres from book " + b);
		Set<Genre> genres = new HashSet<Genre>();
		String sql = "select id, genre from genre join book_genre" + " on genre.id = book_genre.genre_id where"
				+ " book_genre.book_id = ?";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, b.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				log.trace("Found genre: " + rs.getString("genre"));
				Genre g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenre(rs.getString("genre"));
				genres.add(g);
			}
		} catch (SQLException e) {
			LogUtil.logException(e, GenreOracle.class);
		}
		log.trace("getGenre returning " + genres);
		return genres;
	}

	@Override
	public void updateGenre(Genre g) {
		log.trace("Updating Genre to " + g);
		Connection conn = null;
		try {
			conn = cu.getConnection();
			// JDBC Automatically commits all data unless
			// you tell it not to.
			conn.setAutoCommit(false);
			String sql = "update genre set genre = ? where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(2, g.getId());
			stmt.setString(1, g.getGenre());
			int rs = stmt.executeUpdate();
			if (rs != 1) {
				log.warn("Genre update failed.");
				conn.rollback();
				return;
			}
			log.info("Genre updated!");
			conn.commit();
		} catch (SQLException e) {
			LogUtil.rollback(e, conn, GenreOracle.class);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				LogUtil.logException(e, GenreOracle.class);
			}
		}
	}

	@Override
	public void deleteGenre(Genre g) {
		log.trace("Deleting Genre " + g);
		Connection conn = cu.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "delete from genre where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, g.getId());
			int rs = stmt.executeUpdate();
			if (rs != 1) {
				log.warn("Genre delete failed.");
				conn.rollback();
				return;
			}
			log.info("Genre deleted!");
			conn.commit();
		} catch (SQLException e) {
			LogUtil.rollback(e, conn, GenreOracle.class);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				LogUtil.logException(e, GenreOracle.class);
			}
		}
	}

}
