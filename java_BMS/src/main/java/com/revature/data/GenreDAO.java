package com.revature.data;

import java.util.Set;

import com.revature.beans.Book;
import com.revature.beans.Genre;

public interface GenreDAO {
	// Usually a DAO has CRUD methods
	// create = insert
	Integer addGenre(Genre g);
	// read = select
	Genre getGenre(Integer id);
	Genre getGenreByGenre(String genre);
	Set<Genre> getGenres();
	Set<Genre> getGenresByBook(Book b);
	// update = update
	void updateGenre(Genre g);
	// delete = delete
	void deleteGenre(Genre g);
}
