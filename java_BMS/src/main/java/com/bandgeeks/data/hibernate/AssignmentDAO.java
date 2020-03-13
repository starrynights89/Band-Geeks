package com.bandgeeks.data.hibernate;

import java.util.List;

import com.bandgeeks.beans.Assignment;


public interface AssignmentDAO {
	
	public Assignment createAssignment(Assignment a);
	public List<Assignment> getAllAssignments(int instructorId);
	public Assignment getAssignmentById(int id);

}
