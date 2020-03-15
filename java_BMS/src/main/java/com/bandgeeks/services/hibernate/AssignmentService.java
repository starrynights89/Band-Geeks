package com.bandgeeks.services.hibernate;

import java.util.List;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Course;

public interface AssignmentService {
	public Assignment createAssignment(Assignment a, Course course, String instrument);
	public List<Assignment> getAllAssignments(int instructorId, int studentId);
	public Assignment getAssignmentById(int id);
	public boolean gradeAssignment(int id, String grade);

}
