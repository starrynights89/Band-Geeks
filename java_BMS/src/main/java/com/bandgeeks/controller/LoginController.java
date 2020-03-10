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
		User instr = (Instructor) session.getAttribute("loggedInstructor");
		User stu = (Student) session.getAttribute("loggedStudent");

		
		
		log.trace("Getting logged user"+ user);
		
		if(user == null || pass == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			//Check if Instructor
			instr = logServ.loginAsInstructor(user, pass);
			//Check if Student
			//Add to session. 
			//instr = logServ.loginAsInstructor(user.getUsername(), user.getPassword());
			session.setAttribute("loggedUser", log);
			return ResponseEntity.ok(true);
		}

		
	}
	
	
	@PostMapping(value="/login")
	public ResponseEntity<Boolean> postLogin(String user, String pass){
		
		log.trace("Attempting to log in as User "+user+", "+ pass);
		
		if(user == null || pass == null) {
			log.trace("Cannot login null user");
			return ResponseEntity.notFound().build();
		}
		else {
			//Check if Person is a user
			log.trace("Logging in");
			User usr = logServ.getUser(user, pass);
			
			if(usr != null) {
				log.trace("User : "+ usr);
				return ResponseEntity.ok(true);
			}
			return ResponseEntity.ok(false);
			
		}
		
		
	}
	
	
	
	
	

}
