package com.zubentsov.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Value("${email}")
	String email;
	
	@Value("${team}")
	String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDialyWorkout() {
		return "1000 meters as warm up";
	}

	@Override
	public String getDialyFortune() {
		return fortuneService.getFortune();
	}

}
