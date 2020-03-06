package com.revature.driver;

import java.util.Set;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.data.AuthorDAO;
import com.revature.data.BookDAO;
import com.revature.data.hibernate.AuthorHibernate;
import com.revature.data.hibernate.BookHibernate;
import com.revature.utils.HibernateUtil;

public class Driver {
	public static void main(String[] args) {
		BookDAO bd = new BookHibernate();
		AuthorDAO ad = new AuthorHibernate();
		Author a = ad.getAuthorByName("J.K.", "Rowling");
		Set<Book> books = bd.getBooksByAuthor(a);
		for(Book b : books) {
			System.out.println(b);
		}
		HibernateUtil.getInstance().getSessionFactory().close();
	}
}
