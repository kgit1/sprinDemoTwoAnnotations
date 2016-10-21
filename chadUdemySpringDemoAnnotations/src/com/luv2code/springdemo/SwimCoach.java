package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${foo.email}")
	// injects value from our defined properties file
	private String email;
	@Value("${foo.team}")
	// injects value from our defined properties file
	private String team;

	public SwimCoach(FortuneService fortuneService) {
		System.out.println(getClass().getSimpleName() 
				+ ": inside constructor" + " with fields");
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
