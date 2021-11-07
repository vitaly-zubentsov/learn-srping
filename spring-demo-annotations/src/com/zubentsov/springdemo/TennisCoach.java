package com.zubentsov.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	FortuneService fortuneService;
	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDialyWorkout() {
		
		return "Do some move";
	}

	@Override
	public String getDialyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
