package com.bandgeeks.data.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bandgeeks.beans.Instructor;

public interface InstructorDAO {
	
	public Instructor getInstructor(String username, String password);
	public Instructor getInstructorById(int id);
	public List<Instructor> getAllInstructors();
	
	
	

}
