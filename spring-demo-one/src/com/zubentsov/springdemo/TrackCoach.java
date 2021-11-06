package com.zubentsov.springdemo;

public class TrackCoach implements Coach {

	FortuneService fortuneService;
	
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}	
	
	@Override
	public String getDialyWorcout() {
		return "Hard work on track";
	}
	
	@Override
	public String getDialyFortune() {
		
		return fortuneService.getDialyFortune();
	}
	
	public void initYoYo() {
		System.out.println("Do some init staff");
	}
	
	public void closeYoYo() {
		System.out.println("Do some close staff");
	}

}
