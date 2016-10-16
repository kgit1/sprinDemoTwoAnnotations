package com.luv2code.springdemo;

import org.springframework.stereotype.Component;
//show spring that we want that component to be registered as bean
//@Component("thatSillyCoach")

//without explicitly specified bean id - spring will use default component name
//it will be simple class name but starts from lowercase - tennisCoach
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
