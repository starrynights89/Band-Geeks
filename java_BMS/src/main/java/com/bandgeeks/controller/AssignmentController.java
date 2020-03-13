package com.bandgeeks.controller;


import java.util.List;

import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Login;
import com.bandgeeks.data.hibernate.AssignmentHibernate;
import com.bandgeeks.services.hibernate.AssignmentService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AssignmentController {
	private Logger log = Logger.getLogger(AssignmentHibernate.class);

	

		@Autowired
		private AssignmentService assgnServ;
		
		@GetMapping(value="/assignments/instructor/{instructorId}")
		public ResponseEntity<List<Assignment>> getAllAssignments(@PathVariable("instructorId") int instructorId) {
			return ResponseEntity.ok(assgnServ.getAllAssignments(instructorId));
		}
		
		@PostMapping(value="/assignments/instructor")
		public ResponseEntity<Assignment> addAssignment(@RequestBody Assignment a, HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			
			log.trace("LoggedUser "+loggedUser);
			log.trace("CourseId " + loggedUser.getInstructor().getCourse().getCourseId());
			log.trace("CourseId " + a.getInstrument());

			int courseId = loggedUser.getInstructor().getCourse().getCourseId();
			String instrument = a.getInstrument();
			
			a.setInstructorId(loggedUser.getInstructor().getId());
			log.trace("Adding Assignment "+ a);

		

			
			return ResponseEntity.status(201).body(assgnServ.createAssignment(a, courseId, instrument));
		}
		
		@GetMapping(value="/assignments/instructor/{id}")
		public ResponseEntity<Assignment> getAssignment(@PathVariable("id") int id) {
			Assignment a = assgnServ.getAssignmentById(id);
			if(a != null) {
				return ResponseEntity.ok(a);
			}
			return ResponseEntity.notFound().build();
		}
		
//		@PutMapping(value="{id}")
//		public ResponseEntity<Assignment> updateBook(@PathVariable("bookId") int id, @RequestBody Book b) {
//			// possible error handling?
//			bs.updateBook(b);
//			return ResponseEntity.ok(bs.getBookById(id));
//		}
//		



}
