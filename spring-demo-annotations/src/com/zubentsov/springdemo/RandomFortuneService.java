package com.zubentsov.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String[] data = {
		"first fortune",
		"second fortune",
		"third fortune"
	};
	
	Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		return data[index];
	}

}
