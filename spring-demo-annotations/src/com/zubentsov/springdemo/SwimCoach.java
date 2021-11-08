package com.zubentsov.springdemo;

public class SwimCoach implements Coach {

	FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
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
