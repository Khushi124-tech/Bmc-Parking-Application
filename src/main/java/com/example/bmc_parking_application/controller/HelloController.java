package com.example.bmc_parking_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	@GetMapping
	public String Hello() {
		return "Hello Bibi";
	}
}
