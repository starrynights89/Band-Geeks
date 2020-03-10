package com.bandgeeks.services.hibernate;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.User;

public interface LoginService {
	public Instructor loginAsInstructor(User user);
	public Student loginAsStudent(User user);
	public User getUser (String username, String password);
	

}
