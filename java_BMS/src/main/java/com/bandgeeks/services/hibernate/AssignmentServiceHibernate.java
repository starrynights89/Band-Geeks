package com.bandgeeks.services.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;


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
		//set due date and assigned date
		LocalDate dateAssigned = LocalDate.now();
		Date today = Date.valueOf(dateAssigned);
		a.setDateAssigned(today);
		
		LocalDate dateDue = dateAssigned.plusWeeks(2);
		Date due = Date.valueOf(dateDue);
		a.setDateDue(due);

		
		//update Assignment fields
			for(Student s : students) {
				//set student field of assignment
				a.setStudentId(s.getId());
				assgnDAO.createAssignment(a);
			}
		
		

		a.setStudentId(0);

		
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

	@Override
	public boolean gradeAssignment(int id, String grade) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
