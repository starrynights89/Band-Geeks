package com.bandgeeks.services.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.User;
import com.bandgeeks.data.hibernate.UserDAO;


@Service
public class LoginServiceHibernate implements LoginService {

	@Autowired
	private UserDAO uDAO;
	
	
	@Override
	public Instructor loginAsInstructor(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student loginAsStudent(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return uDAO.getUser(username, password);
	}

}
