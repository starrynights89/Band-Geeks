package com.bandgeeks.services.hibernate;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.User;

public interface LoginService {
	public Instructor loginAsInstructor(String user, String pass);
	public Student loginAsStudent(String user, String pass);
	public User getUser (String username, String password);
	

}
