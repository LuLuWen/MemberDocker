package com.java.spring.mongoDB.controller;

import org.springframework.stereotype.*;  
import org.springframework.web.bind.annotation.*;  
  
@Controller
public class RoutingController {  
   
	@GetMapping("/templates")
	public String test() {
		
		return "/index";

	}
}