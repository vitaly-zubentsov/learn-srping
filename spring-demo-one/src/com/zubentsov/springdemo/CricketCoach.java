package com.zubentsov.springdemo;

public class CricketCoach implements Coach {

	FortuneService fortuneService;
	
	String emailAddress;
	String team;
	
	public CricketCoach () {
		System.out.println("constractor for criket coach - nothing to do");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setter for fortune service");
		this.fortuneService = fortuneService;
	}
	
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public String myCricketCoach() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDialyWorcout() {
		return "nothing to do, it is a cricket";
	}

	@Override
	public String getDialyFortune() {
		return fortuneService.getDialyFortune();
	}

}
