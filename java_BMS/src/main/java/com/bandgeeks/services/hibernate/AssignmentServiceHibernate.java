package com.bandgeeks.services.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Student;
import com.bandgeeks.data.hibernate.AssignmentDAO;
import com.bandgeeks.data.hibernate.StudentDAO;

@Service
public class AssignmentServiceHibernate implements AssignmentService{
	
	@Autowired
	private AssignmentDAO assgnDAO;
	
	@Autowired
	private StudentDAO stuDAO;

	@Override
	public Assignment createAssignment(Assignment a, int courseId, String instrument) {
		// Get All students in this course
		List<Student> students = new ArrayList<>();
		students = stuDAO.getAllStudentsByCourseId(courseId);
		
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