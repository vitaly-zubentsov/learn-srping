package com.zubentsov.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDialyWorkout() {
		
		return "Do some move";
	}

}
