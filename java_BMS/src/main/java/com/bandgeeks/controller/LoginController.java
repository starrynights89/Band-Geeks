package com.bandgeeks.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.Instructor;
import com.bandgeeks.beans.Login;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.User;
import com.bandgeeks.services.hibernate.LoginService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	private Logger log = Logger.getLogger(LoginController.class);


	
	@Autowired
	private LoginService logServ;

	
	
	@GetMapping(value="/login")
	public ResponseEntity<Boolean> getlogin(HttpSession session, String user, String pass) {
		Instructor instr = (Instructor) session.getAttribute("loggedInstructor");
		Student stu = (Student) session.getAttribute("loggedStudent");

		
		
		log.trace("Getting logged user"+ user);
		
		if(user == null || pass == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			//Check if Instructor
			instr = logServ.loginAsInstructor(user, pass);
			session.setAttribute("loggedInstructor", instr);
			//Check if Instructor
			stu = logServ.loginAsStudent(user, pass);
			session.setAttribute("loggedStudent", stu);

			return ResponseEntity.ok(true);
		}

		
	}
	
	
	@PostMapping(value="/login")
	public ResponseEntity<Object> postLogin(String user, String pass, HttpSession session){
		Instructor instr = (Instructor) session.getAttribute("loggedInstructor");
		Student stu = (Student) session.getAttribute("loggedStudent");


		
		log.trace("Attempting to log in as User "+user+", "+ pass);
		
		if(user == null || pass == null) {
			log.trace("Cannot login null user");
			return ResponseEntity.notFound().build();
		}
		else {
			//Check if Person is a user
			log.trace("Logging in");
			instr = logServ.loginAsInstructor(user, pass);
			stu = logServ.loginAsStudent(user, pass);

			
			if(instr != null) {
				log.trace("Instructor : "+ instr);
				session.setAttribute("loggedInstructor", instr);

				return ResponseEntity.ok(instr);
			}
			else if (stu != null){
				log.trace("Student : "+ stu);
				session.setAttribute("loggedStudent", stu);

				return ResponseEntity.ok(stu);
				
			}
			else {
				log.trace("No User found");
			}
			return ResponseEntity.ok(false);
			
		}
		
		
	}
	
	
	
	
	

}
