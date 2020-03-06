package com.revature.services.hibernate;

import com.revature.beans.User;

public interface UserService {
	
	public User getUser(String username, String password);
	public User getUserById(int id);

}
