package com.bandgeeks.data.hibernate;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.User;
import com.bandgeeks.controller.LoginController;
import com.bandgeeks.utils.HibernateUtil;


@Repository
public class InstructorHibernate implements InstructorDAO{
	private Logger log = Logger.getLogger(LoginController.class);

	private static HibernateUtil hu = HibernateUtil.getInstance();




	@Override
	public Instructor getInstructor(String username, String password) {
		log.trace("Getting Instructor "+username+", "+password);

		Session s = hu.getSession();
		log.trace("Session"+s);
		String query = "from Instructor u where u.username=:username and u.password=:password";
		Query q = s.createQuery(query, Instructor.class);
		log.trace("q"+q);
		q.setParameter("username", username);
		q.setParameter("password", password);
		Instructor u = (Instructor) q.uniqueResult();
		s.close();
		return u;
	}

	@Override
	public Instructor getInstructorById(int id) {
		log.trace("Getting Instructor by Id "+id);
		Session s = hu.getSession();
		Instructor ret = s.get(Instructor.class, id);
		s.close();
		return ret;
	}

	@Override
	public List<Instructor> getAllInstructors() {
		log.trace("Getting all Instructors");

			Session s = hu.getSession();
			String query = "FROM instructors";
			Query<Instructor> q = s.createQuery(query, Instructor.class);
			List<Instructor> instrList = q.getResultList();
			s.close();
			return instrList;

	}

}
