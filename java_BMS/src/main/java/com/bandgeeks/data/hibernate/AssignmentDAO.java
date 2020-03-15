package com.bandgeeks.data.hibernate;

import java.util.List;

import com.bandgeeks.beans.Assignment;


public interface AssignmentDAO {
	
	public Assignment createAssignment(Assignment a);
	public List<Assignment> getAllAssignments(int instructorId, int studentId);
	public Assignment getAssignmentById(int id);
	public boolean gradeAssignment(int id, String grade);
	public boolean updateAssignment(Assignment a);


}
