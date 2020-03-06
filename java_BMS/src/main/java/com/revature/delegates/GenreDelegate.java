package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Genre;
import com.revature.services.GenreService;
import com.revature.services.hibernate.GenreServiceHibernate;

public class GenreDelegate implements FrontControllerDelegate {
	private Logger log = Logger.getLogger(GenreDelegate.class);
	private GenreService gs = new GenreServiceHibernate();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String path = (String) req.getAttribute("path");
		log.trace(path);		
		if(path == null) {
			// We operate on the entire colletion
			collectionOperations(req, resp);
		} else {
			if(path.indexOf("/")!=-1)
				path = path.substring(0, path.indexOf("/"));
			// Operating on single genre
			singleGenre(req, resp, Integer.parseInt(path));
		}
	}

	private void singleGenre(HttpServletRequest req,
			HttpServletResponse resp, int id)
					throws IOException, ServletException {
		log.trace(id);
		// GET, PUT, or a DELETE
		Genre g = gs.getGenreById(id);
		log.trace(req.getMethod());
		switch(req.getMethod()) {
		case "GET":
			resp.getWriter().write(om.writeValueAsString(g));
			break;
		case "PUT":
			g = om.readValue(req.getInputStream(), Genre.class);
			gs.updateGenre(g);
			resp.getWriter().write(om.writeValueAsString(g));
			break;
		case "DELETE":
			gs.deleteGenre(g);
			resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
			break;
		default:
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		}
	}

	private void collectionOperations(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		// Only allowing GET and POST on the collection
		switch(req.getMethod()) {
		case "GET":
			resp.getWriter().write(om.writeValueAsString(gs.getGenres()));
			break;
		case "POST":
			Genre g = om.readValue(req.getInputStream(), Genre.class);
			gs.addGenre(g);
			if(g.getId()==0) {
				resp.sendError(HttpServletResponse.SC_CONFLICT);
				return;
			}
			resp.setStatus(HttpServletResponse.SC_CREATED);
			resp.getWriter().write(om.writeValueAsString(g));
			break;
		default:
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		}
		
	}

}
