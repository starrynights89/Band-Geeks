package com.bandgeeks.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bandgeeks.beans.Comment;
import com.bandgeeks.utils.HibernateUtil;
import com.bandgeeks.utils.LogUtil;

@Repository
public class CommentHibernate implements CommentDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Integer addComment(Comment comment) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(comment);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, CommentHibernate.class);
		} finally {
			s.close();
		}
		return comment.getCommentsId();
	}

	@Override
	public Comment getComment(Comment comment) {
		Session s = hu.getSession();
		comment = s.get(Comment.class, comment.getCommentsId());
		s.close();

		return comment;
	}

	@Override
	public Set<Comment> getAllComments() {
		Session s = hu.getSession();
		String query = "SELECT * FROM comments";
		Query<Comment> q = s.createQuery(query, Comment.class);
		List<Comment> commentList = q.getResultList();
		Set<Comment> commentSet = new HashSet<Comment>();
		commentSet.addAll(commentList);
		s.close();
		return commentSet;
	}

}
