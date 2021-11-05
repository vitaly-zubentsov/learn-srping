package com.zubentsov.springdemo;

public class BaseballCoach  implements Coach {

	FortuneService fortuneService;
	
	
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}



	@Override
	 public String getDialyWorcout() {
		return "30 minutes a day";
	}



	@Override
	public String getDialyFortune() {
		
		return fortuneService.getDialyFortune();
	}
}
