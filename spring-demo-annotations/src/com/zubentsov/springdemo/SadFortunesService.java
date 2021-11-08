package com.zubentsov.springdemo;

public class SadFortunesService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "it's lonely day. And it's mine.";
	}

}
