package com.zubentsov.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSillyMember() {

		System.out.println(this.getClass() + " Adding a membership account");
	}

	public void goToSleep() {

		System.out.println(this.getClass() + "I'm going to sleep");
	}

}
