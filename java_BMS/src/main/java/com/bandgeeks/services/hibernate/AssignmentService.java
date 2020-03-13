package com.bandgeeks.services.hibernate;

import java.util.List;

import com.bandgeeks.beans.Assignment;

public interface AssignmentService {
	public Assignment createAssignment(Assignment a, int courseId, String instrument);
	public List<Assignment> getAllAssignments(int instructorId);
	public Assignment getAssignmentById(int id);

}
