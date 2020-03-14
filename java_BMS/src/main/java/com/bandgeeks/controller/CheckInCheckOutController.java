package com.bandgeeks.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.IDisplayInv;
import com.bandgeeks.beans.Instrument;
import com.bandgeeks.beans.Inventory;
import com.bandgeeks.beans.Uniform;
import com.bandgeeks.data.hibernate.InstrumentHibernate;
import com.bandgeeks.data.hibernate.UniformHibernate;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckInCheckOutController {
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
//    @GetMapping(value = "/inventory")
//	public ResponseEntity<Set<Instrument>> getInstrument(HttpSession session) {
//    	InstrumentHibernate iH = new InstrumentHibernate();
//    	Set<Instrument> i = iH.getInstruments();
//		return ResponseEntity.ok(i);
//	
//	}
}