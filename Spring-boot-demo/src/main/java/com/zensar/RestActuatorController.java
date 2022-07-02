package com.zensar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestActuatorController {
	@GetMapping("/hello")
    public String hello() {
    	return "hello world";
    	
    }
}
