package com.bandgeeks.data.hibernate;

import org.springframework.stereotype.Repository;

import com.bandgeeks.beans.Assignment;

@Repository
public class AssignmentHibernate implements AssignmentDAO {

	@Override
	public boolean createAssignment(Assignment a) {
		// Add assignment to the database.
		return false;
	}

	@Override
	public boolean getAllAssignments(int instructorId) {
		// Get all assignments by instructor Id.
		
		return false;
	}

	@Override
	public boolean getAssignmentById(int id) {
		// Get assignment by assignment id.
		return false;
	}
	

}
