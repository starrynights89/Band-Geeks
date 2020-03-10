package com.bandgeeks.controller;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.User;
import com.bandgeeks.services.hibernate.LoginService;



@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class LoginController {
	
	private Logger log = Logger.getLogger(LoginController.class);


	
	@Autowired
	private LoginService logServ;
	
	
	@GetMapping(value="/login")
	public ResponseEntity<User> getlogin(HttpSession session) {
		User user = (User) session.getAttribute("loggedUser");
		
		log.trace("Getting logged user"+ user);
		
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			User log = logServ.getUser(user.getUsername(), user.getPassword());
			session.setAttribute("loggedUser", log);
			return ResponseEntity.ok(log);
		}

		
	}
	
	
//	@PostMapping(value="/login")
//	public ResponseEntity<User> postLogin(@PathVariable ){
//		
//	}
	
	
	
	
	

}
