package com.zubentsov.springboot.demo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	//inject properties 
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + "; Team: " + teamName;
	}

	@GetMapping("/")
	public String helloWorld() {
		return "HELLO WORLD! Current time: " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String doWorkout() {
		return "run 5 km";
	}
}
