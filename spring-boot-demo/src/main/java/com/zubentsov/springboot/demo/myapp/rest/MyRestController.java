package com.zubentsov.springboot.demo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("/")
	public String helloWorld() {
		return "HELLO WORLD! Current time: " + LocalDateTime.now();
	}
}
