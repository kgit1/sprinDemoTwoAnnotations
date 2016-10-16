package com.luv2code.springdemo;

import org.springframework.stereotype.Component;
//show spring that we want that component to be registered as bean
@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
