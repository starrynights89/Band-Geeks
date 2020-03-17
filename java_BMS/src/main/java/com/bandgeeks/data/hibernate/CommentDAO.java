package com.bandgeeks.data.hibernate;

import java.util.Set;

import com.bandgeeks.beans.Comment;

public interface CommentDAO {

	public Integer addComment (Comment comment);

	public Comment getComment (Comment comment); 
	
	public Set<Comment> getAllComments();
}
