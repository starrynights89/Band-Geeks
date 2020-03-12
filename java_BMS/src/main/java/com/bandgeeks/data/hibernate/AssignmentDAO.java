package com.bandgeeks.data.hibernate;

import com.bandgeeks.beans.Assignment;

public interface AssignmentDAO {
	
	public boolean createAssignment(Assignment a);
	public boolean getAllAssignments(int instructorId);
	public boolean getAssignmentById(int id);

}
