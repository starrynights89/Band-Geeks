package com.bandgeeks.services.hibernate;



import org.apache.log4j.Logger;

import com.bandgeeks.beans.User;
import com.bandgeeks.data.hibernate.UserDAO;
import com.bandgeeks.data.hibernate.UserHibernate;



public class UserServiceHibernate implements UserService {
	private Logger log = Logger.getLogger(UserServiceHibernate.class);
	private UserDAO uDAO = new UserHibernate();
	
	
	
	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return uDAO.getUser(username, password);
	}
	
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return uDAO.getUserById(id);
	}





}
