package com.revature.services.hibernate;



import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.data.hibernate.UserDAO;
import com.revature.data.hibernate.UserHibernate;



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
