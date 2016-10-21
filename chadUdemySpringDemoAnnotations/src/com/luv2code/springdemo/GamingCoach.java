package com.luv2code.springdemo;

public class GamingCoach implements Coach{
	FortuneService fortuneService;

	public GamingCoach(FortuneService fortuneService) {
		System.out.println(getClass().getSimpleName() + ": inside constructor"
				+ " with fields");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return getClass().getSimpleName() + ": 6 hours of dm6";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	
	
	
}
