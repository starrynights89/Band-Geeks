package com.bandgeeks.data.hibernate;

import com.bandgeeks.beans.User;

public interface UserDAO {
	
	public int addUser(User user);
	public User getUser(String username, String password);
	public User getUser(User u);
	public User getUserById(int id);
	public void deleteUser(User user);
	public void updateUser(User user);
	
	

}
