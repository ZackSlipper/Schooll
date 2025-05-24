package com.kitm.springtest.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {
	@Value("${teacher.name}")
	private String teacherName;

	@Value("${teacher.school}")
	private String teacherSchool;

	@GetMapping("/")
	public String sayHello() {
		return "Hello, World!";
	}

	@GetMapping("/profile")
	public String showProfile() {
		return "Welcome to my profile. My name is " + teacherName + " and I work at " + teacherSchool + ".";
	}
	
}
