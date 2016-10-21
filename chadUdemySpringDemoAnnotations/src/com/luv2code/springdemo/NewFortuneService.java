package com.luv2code.springdemo;

public class NewFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "I have socks smarter than you!";
	}

}
