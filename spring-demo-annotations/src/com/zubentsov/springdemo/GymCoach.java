package com.zubentsov.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach {

	@Autowired
	@Qualifier("randomArrayFortuneService")
	FortuneService fortuneService;
	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	/*@Autowired
	public void someMethod(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDialyWorkout() {
		
		return "No pain, no gain";
	}

	@Override
	public String getDialyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	void init() {
		System.out.println("post construct method");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("pre destroy method");
	}
	
	

}
