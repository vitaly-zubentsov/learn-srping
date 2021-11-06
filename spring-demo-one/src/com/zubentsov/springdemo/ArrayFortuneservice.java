package com.zubentsov.springdemo;

import java.util.Random;

public class ArrayFortuneservice implements FortuneService {

	
	String[] fortunes;
	Random randomNumber = new Random();
	
	
	public String[] getFortunes() {
		return fortunes;
	}


	public void setFortunes(String[] fortunes) {
		this.fortunes = fortunes;
	}


	@Override
	public String getDialyFortune() {
		return fortunes[randomNumber.nextInt(2)];
	}

}
