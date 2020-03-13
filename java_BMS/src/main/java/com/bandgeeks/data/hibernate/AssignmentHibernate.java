package com.bandgeeks.data.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Instructor;
import com.bandgeeks.controller.LoginController;
import com.bandgeeks.utils.HibernateUtil;
import com.bandgeeks.utils.LogUtil;

@Repository
public class AssignmentHibernate implements AssignmentDAO {
	private static HibernateUtil hu = HibernateUtil.getInstance();

	private Logger log = Logger.getLogger(AssignmentHibernate.class);


	@Override
	public Assignment createAssignment(Assignment a) {
		// Add assignment to the database.
		Integer id = null;
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			id = (Integer) s.save(a);
			t.commit();
		} catch(HibernateException e) {
			if (t != null)
				t.rollback();
			LogUtil.logException(e, AssignmentHibernate.class);
			return null;

		} finally {
			s.close();
		}
		return a;

		
	}

	@Override
	public List<Assignment> getAllAssignments(int instructorId) {
		// Get all assignments by instructor Id.
		log.trace("Getting all Assignments for instructor");

		Session s = hu.getSession();
		Query<Assignment> q = s.createQuery("FROM Assignment where id =:id", Assignment.class);
		q.setParameter("id", instructorId);
		List<Assignment> assignmentList = q.getResultList();
		s.close();
		return assignmentList;
	}

	@Override
	public Assignment getAssignmentById(int id) {
		// Get assignment by assignment id.
		log.trace("Getting Assignment by Id "+id);
		Session s = hu.getSession();
		Assignment ret = s.get(Assignment.class, id);
		s.close();
		return ret;
	}
	

}
