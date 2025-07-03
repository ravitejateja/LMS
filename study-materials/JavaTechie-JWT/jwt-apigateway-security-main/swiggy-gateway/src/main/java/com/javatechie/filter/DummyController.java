package com.javatechie.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
	
	@RequestMapping("/dummy")
	public String myDummyTest() {
		return "ok";
	}

}
