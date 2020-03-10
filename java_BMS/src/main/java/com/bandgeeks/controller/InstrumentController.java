package com.bandgeeks.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandgeeks.beans.Instrument;

@RestController
//@CrossOrigin(origins="http://localhost:4200") // for avoiding CORS errors when using Angular.
@RequestMapping(path = "/instrument")
public class InstrumentController {
	@GetMapping("/getAvailable")
	public ResponseEntity<Set<Instrument>> getAvailableInstruments() {
		Instrument inst1 = new Instrument();
		inst1.setInstrumentId(1);
		inst1.setInstrumentName("Trumpet");
		Instrument inst2 = new Instrument();
		inst2.setInstrumentId(2);
		inst2.setInstrumentName("Trombone");
		Set<Instrument> inst = new HashSet<Instrument>();
		inst.add(inst1);
		inst.add(inst2);
		return ResponseEntity.ok(inst);
	}
}
