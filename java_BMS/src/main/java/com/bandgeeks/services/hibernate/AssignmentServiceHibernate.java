package com.bandgeeks.services.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.data.hibernate.AssignmentDAO;

@Service
public class AssignmentServiceHibernate implements AssignmentService{
	
	@Autowired
	private AssignmentDAO assgnDAO;

	@Override
	public Assignment createAssignment(Assignment a) {
		// TODO Auto-generated method stub
		return assgnDAO.createAssignment(a);
	}

	@Override
	public List<Assignment> getAllAssignments(int instructorId) {
		// TODO Auto-generated method stub
		return assgnDAO.getAllAssignments(instructorId);
	}

	@Override
	public Assignment getAssignmentById(int id) {
		// TODO Auto-generated method stub
		return assgnDAO.getAssignmentById(id);
	}
	

}