package com.revature.data.hibernate;

import com.revature.beans.User;

public interface UserDAO {
	
	public int addUser(User user);
	public User getUser(String username, String password);
	public User getUser(User u);
	public User getUserById(User u);
	public void deleteUser(User user);
	public void updateUser(User user);
	
	

}
