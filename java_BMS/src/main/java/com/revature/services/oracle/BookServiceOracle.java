package com.revature.services.oracle;

import java.util.Set;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.beans.Customer;
import com.revature.beans.Genre;
import com.revature.data.AuthorDAO;
import com.revature.data.BookDAO;
import com.revature.data.GenreDAO;
import com.revature.data.oracle.AuthorOracle;
import com.revature.data.oracle.BookOracle;
import com.revature.data.oracle.GenreOracle;
import com.revature.services.BookService;

public class BookServiceOracle implements BookService {
	private BookDAO bd = new BookOracle();
	private AuthorDAO ad = new AuthorOracle();
	private GenreDAO gd = new GenreOracle();
	
	@Override
	public Set<Book> getBooksForReadingList(Customer cust) {
		Set<Book> books = bd.getReadingList(cust);
		for (Book b : books) {
			b.setAuthors(ad.getAuthorsByBook(b));
			b.setGenres(gd.getGenresByBook(b));
		}
		return books;
	}

	@Override
	public Set<Book> getBooks() {
		Set<Book> books = bd.getBooks();
		for(Book b: books) {
			b.setAuthors(ad.getAuthorsByBook(b));
			b.setGenres(gd.getGenresByBook(b));
		}
		return books;
	}

	@Override
	public Book getBookById(int id) {
		Book b = bd.getBook(id);
		b.setAuthors(ad.getAuthorsByBook(b));
		b.setGenres(gd.getGenresByBook(b));
		return b;
	}

	@Override
	public void updateBook(Book b) {
		// We need to check to see if the authors and genres
		// are in the database before we update the book
		checkAuthorsAndGenres(b);
		bd.updateBook(b);
	}

	

	@Override
	public void deleteBook(Book b) {
		bd.deleteBook(b);
	}

	@Override
	public void addBook(Book b) {
		checkAuthorsAndGenres(b);
		bd.addBook(b);		
	}

	private void checkAuthorsAndGenres(Book b) {
		Set<Author> authors = b.getAuthors();
		for(Author a: authors) {
			if(ad.getAuthor(a.getId())!=null) {
				ad.updateAuthor(a);
			} else {
				ad.addAuthor(a);
			}
		}
		Set<Genre> genres = b.getGenres();
		for (Genre g : genres) {
			if (gd.getGenre(g.getId()) != null) {
				gd.updateGenre(g);
			} else {
				gd.addGenre(g);
			}
		}
	}
}
