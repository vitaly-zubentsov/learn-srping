package com.zubentsov.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortunesService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "It is a lucky day";
	}

}
