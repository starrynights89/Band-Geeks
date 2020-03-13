package com.bandgeeks.services.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Course;
import com.bandgeeks.beans.Student;
import com.bandgeeks.data.hibernate.AssignmentDAO;
import com.bandgeeks.data.hibernate.InstrumentDAO;
import com.bandgeeks.data.hibernate.StudentDAO;

@Service
public class AssignmentServiceHibernate implements AssignmentService{
	
	@Autowired
	private AssignmentDAO assgnDAO;
	
	@Autowired
	private StudentDAO stuDAO;
	
	@Autowired
	private InstrumentDAO instrDAO;

	@Override
	public Assignment createAssignment(Assignment a, Course course, String instrument) {
		// Get All students in this course
		int instrumentId = 0;
		List<Student> students = new ArrayList<>();
		students = stuDAO.getAllStudentsByCourse(course);
		
		
		if (instrument != "") {
			instrumentId = instrDAO.getInstrumentByName(instrument).getId();
			students = stuDAO.getStudentsByInstrument(instrumentId);
		}
		
		//update Assignment fields
			for(Student s : students) {
				//set student field of assignment
				a.setStudentId(s);
				assgnDAO.createAssignment(a);
			}
		
		

		a.setStudentId(null);

		
		return a;
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