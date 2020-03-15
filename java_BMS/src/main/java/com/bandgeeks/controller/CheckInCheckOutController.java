package com.bandgeeks.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.IDisplayInv;
import com.bandgeeks.beans.Instrument;
import com.bandgeeks.beans.Inventory;
import com.bandgeeks.beans.Login;
import com.bandgeeks.beans.Request;
import com.bandgeeks.beans.Status;
import com.bandgeeks.beans.Student;
import com.bandgeeks.beans.Uniform;
import com.bandgeeks.data.hibernate.InstrumentHibernate;
import com.bandgeeks.data.hibernate.RequestHibernate;
import com.bandgeeks.data.hibernate.UniformHibernate;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckInCheckOutController {
	private Logger log = Logger.getLogger(CheckInCheckOutController.class);

    @GetMapping(value = "/inventory")
	public ResponseEntity<Set<IDisplayInv>> getUniform(HttpSession session) {
    	Set<IDisplayInv> iDI = new HashSet<IDisplayInv>();
    	UniformHibernate uH = new UniformHibernate();
    	Set<Uniform> u = uH.getUniforms();
    	InstrumentHibernate iH = new InstrumentHibernate();
    	Set<Instrument> i = iH.getInstruments();
    	iDI.addAll(u);
    	iDI.addAll(i);
		return ResponseEntity.ok(iDI);
	
	}
    @PostMapping(value = "/add/{productId}")
    public ResponseEntity<Request> addRequest(@PathVariable("productId") String itemId, HttpSession session){
    	log.trace("In Post method");
    	log.trace(itemId);
    	//setting fake data to make sure it works while logged in
//    	Student sFake = new Student();
//    	sFake.setId(1);
//    	Login lFake = new Login();
//    	lFake.setStudent(sFake);
//    	session.setAttribute("loggedUser", lFake);
    	//get rid of it when done setting it up with login
    	Login l = (Login) session.getAttribute("loggedUser");
    	log.trace(l);
    	Student s = l.getStudent();
    	Inventory i = new Inventory(Integer.parseInt(itemId));
    	Request r = new Request(null, i, s);
    	Status status = new Status(1);
    	r.setStatus(status);
    	RequestHibernate rH = new RequestHibernate();
    	r.setRequestId(rH.createRequest(r));
		return ResponseEntity.ok(r);
    }
}