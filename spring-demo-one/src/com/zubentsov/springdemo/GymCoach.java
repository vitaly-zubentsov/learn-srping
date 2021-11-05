package com.zubentsov.springdemo;

public class GymCoach implements Coach {

	FortuneService fortuneService;
	
	
	
	public GymCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDialyWorcout() {
		return "1 hour in gym";
	}
	
	@Override
	public String getDialyFortune() {
		
		return fortuneService.getDialyFortune();
	}

}
