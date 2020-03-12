package com.bandgeeks.data.hibernate;

import org.hibernate.query.Query;


import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.User;
import com.bandgeeks.controller.LoginController;
import com.bandgeeks.utils.HibernateUtil;
import com.bandgeeks.utils.LogUtil;



@Repository

public class StudentHibernate implements StudentDAO{
	private Logger log = Logger.getLogger(StudentHibernate.class);

	private static HibernateUtil hu = HibernateUtil.getInstance();





	@Override
	public Student getStudent (String user, String pass) {
		log.trace("Getting Student "+user+", "+pass);
		Session s = hu.getSession();
		Query<Student> q = s.createQuery("FROM Student where username =:username and password=:password", Student.class);
		q.setParameter("username", user);
		q.setParameter("password",  pass);
		Student a = q.uniqueResult();
		s.close();
		return a;
	}

	@Override
	public Student getStudentById(int id) {
		log.trace("Getting Student by Id "+id);
		Session s = hu.getSession();
		Student ret = s.get(Student.class, id);
		s.close();
		return ret;
	}

	@Override
	public List<Instructor> getAllStudents() {
		log.trace("Getting all Instructors");

			Session s = hu.getSession();
			String query = "FROM Student";
			Query<Instructor> q = s.createQuery(query, Instructor.class);
			List<Instructor> instrList = q.getResultList();
			s.close();
			return instrList;

	}

}