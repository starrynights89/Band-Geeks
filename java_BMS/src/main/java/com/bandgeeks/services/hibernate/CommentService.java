package com.bandgeeks.services.hibernate;

import java.util.Set;

import com.bandgeeks.beans.Comment;

public interface CommentService {

	public Integer addComment (Comment comment);

	public Comment getComment (Comment comment); 
	
	public Set<Comment> getAllComments();
}
