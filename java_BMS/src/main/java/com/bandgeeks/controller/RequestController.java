package com.bandgeeks.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {

	private Logger log = Logger.getLogger(RequestController.class);
}
