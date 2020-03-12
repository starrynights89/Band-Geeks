package com.bandgeeks.data.hibernate;

import java.util.List;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Student;

public interface StudentDAO {
	
	public Student getStudent(String username, String password);
	public Student getStudentById(int id);
	public List<Instructor> getAllStudents();
	
	
	

}
