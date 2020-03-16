package com.bandgeeks.services.hibernate;

import java.util.List;

import com.bandgeeks.beans.User;

public interface UserService {
	public List<User> getAllUsers(int userId);
	public boolean addNewUser();
	

}
