package com.bandgeeks.controller;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Chatter;
import com.bandgeeks.beans.Course;
import com.bandgeeks.beans.Login;
import com.bandgeeks.beans.User;
import com.bandgeeks.data.hibernate.AssignmentHibernate;
import com.bandgeeks.services.hibernate.AssignmentService;
import com.bandgeeks.services.hibernate.ChatterService;
import com.bandgeeks.services.hibernate.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	private Logger log = Logger.getLogger(UserController.class);

	

		@Autowired
		private UserService uServ;
		
		@GetMapping(value="/user")
		public ResponseEntity<List<User>> getAllUnreadMessages(HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			if(loggedUser.getInstructor() != null) {
			
				int instructorId = loggedUser.getInstructor().getId();
				
				return ResponseEntity.ok(uServ.getAllUsers(instructorId));
			}
			
			else if(loggedUser.getStudent() != null) {
				
				int studentId = loggedUser.getStudent().getId();
				
				return ResponseEntity.ok(uServ.getAllUsers(studentId));
			}
			else {
				return ResponseEntity.notFound().build();

			}
			
		}
		
//		@PostMapping(value="/chat")
//		public ResponseEntity<Chatter> addAssignment(@RequestBody Chatter c, HttpSession session) {
//			Login loggedUser = (Login) session.getAttribute("loggedUser");
//			
//			log.trace("LoggedUser "+loggedUser);
//			
//			if(loggedUser.getInstructor() != null) {
//				c.setSender(loggedUser.getInstructor().getId());
//			}
//			
//			if(loggedUser.getStudent() != null) {
//				c.setSender(loggedUser.getStudent().getId());
//			}
//			
//			
//			log.trace("Adding Message "+ c);
//
//		
//
//			
//			return ResponseEntity.status(201).body(cServ.createMessage(c));
//		}
		
//		@PutMapping(value="/chat/{id}")
//		public ResponseEntity<Boolean> getAssignment(@PathVariable("id") int id, HttpSession session) {
//			Login loggedUser = (Login) session.getAttribute("loggedUser");
//			if(loggedUser.getInstructor() != null) {
//			
//				Boolean a = assgnServ.gradeAssignment(id, grade);
//				if(a != null) {
//					return ResponseEntity.ok(a);
//				}
//			}
//			
//			else if(loggedUser.getStudent() != null) {
//				
//				Boolean a = assgnServ.turnInAssignment(id);
//				if(a != null) {
//					return ResponseEntity.ok(a);
//				}
//			}
//			
//			return ResponseEntity.notFound().build();
//		}

//		



}
