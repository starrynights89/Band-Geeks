package com.bandgeeks.services.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.User;
import com.bandgeeks.data.hibernate.InstructorDAO;
import com.bandgeeks.data.hibernate.StudentDAO;
import com.bandgeeks.data.hibernate.UserDAO;


@Service
public class LoginServiceHibernate implements LoginService {

	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private InstructorDAO instrDAO;
	@Autowired
	private StudentDAO stuDAO;
	
	
	@Override
	public Instructor loginAsInstructor(String user, String pass) {
		// TODO Auto-generated method stub
		return instrDAO.getInstructor(user, pass) ;
	}

	@Override
	public Student loginAsStudent(String user, String pass) {
		// TODO Auto-generated method stub
		return stuDAO.getStudent(user, pass);
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return uDAO.getUser(username, password);
	}

	@Override
	public Instructor getById(int id) {
		// TODO Auto-generated method stub
		return instrDAO.getInstructorById(3);
	}

}
