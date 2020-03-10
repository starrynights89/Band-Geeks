package com.bandgeeks.services.hibernate;

import com.bandgeeks.beans.User;

public interface UserService {
	
	public User getUser(String username, String password);
	public User getUserById(int id);

}
