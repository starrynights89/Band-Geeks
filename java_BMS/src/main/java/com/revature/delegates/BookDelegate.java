package com.revature.delegates;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Book;
import com.revature.services.BookService;
import com.revature.services.hibernate.BookServiceHibernate;
import com.revature.utils.LogUtil;

public class BookDelegate implements FrontControllerDelegate {
	private Logger log = Logger.getLogger(BookDelegate.class);
	private ObjectMapper om = new ObjectMapper();
	private BookService bs = new BookServiceHibernate();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// figure out if we're operating on the 
		// collection or a specific resource.
		String path = (String) req.getAttribute("path");
		log.trace("path: "+path);
		if(path==null||"".equals(path)) {
			// collection
			collectionOperations(req, resp);
		} else {
			// specific resource
			if(path.indexOf("/")!=-1)
				path = path.substring(0, path.indexOf("/"));
			try {
				bookTimes(req, resp, Integer.parseInt(path));
			} catch(NumberFormatException e) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
	}

	private void bookTimes(HttpServletRequest req, HttpServletResponse resp, int id) throws JsonProcessingException, IOException {
		Book b = null;
		switch(req.getMethod()) {
		case "GET":
			log.trace("get specific book. id: "+id);
			resp.getWriter()
				.write(om.writeValueAsString(
						bs.getBookById(id)));
			return;
		case "PUT":
			log.trace("update book with id: "+id);
			b = om.readValue(req.getInputStream(), Book.class);
			log.trace(b);
			if(b==null)
				return;
			bs.updateBook(b);
			resp.getWriter().write(om.writeValueAsString(b));
			return;
		case "DELETE":
			log.trace("deleting book with id: "+id);
			b = bs.getBookById(id);
			bs.deleteBook(b);
			resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		default:
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
	}

	private void collectionOperations(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		switch(req.getMethod()) {
		case "GET": 
			log.trace("Get called with books.");
			Set<Book> books = bs.getBooks();
			String respBooks = om.writeValueAsString(books);
			resp.getWriter().write(respBooks);
			return;
		case "POST": 
			log.trace("Post called with books.");
			Book b = om.readValue(req.getInputStream(), Book.class);
			log.trace(b);
			if(b==null)
				return;
			try {
				// add to db
				log.trace("Adding book to db: "+b);
				bs.addBook(b);
				resp.setStatus(HttpServletResponse.SC_CREATED);
				resp.getWriter().write(om.writeValueAsString(b));
			} catch(Exception e) {
				LogUtil.logException(e, BookDelegate.class);
				resp.sendError(HttpServletResponse.SC_CONFLICT);
			}
			return;
		default: resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); return;
		}
	}
}
