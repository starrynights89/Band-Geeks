package com.bandgeeks.services.hibernate;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Comment;
import com.bandgeeks.data.hibernate.CommentDAO;

@Service
public class CommentServiceHibernate implements CommentService {

	private Logger log = Logger.getLogger(RequestServiceHibernate.class);
	@Autowired
	private CommentDAO cd;
	
	@Override
	public Integer addComment(Comment comment) {
		log.trace("attempting to add comment");
		cd.addComment(comment);
		return comment.getCommentsId();
		
	}

	@Override
	public Comment getComment(Comment comment) {
		log.trace("attempting to get comment");
		if (comment == null) {
			return null;
		} else cd.getComment(comment);
		return comment;
	}

	@Override
	public Set<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

}
