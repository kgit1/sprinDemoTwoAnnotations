package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
//show spring that we want that component to be registered as bean
@Component
//without explicitly specified bean id - spring will use default component name
//it will be simple class name but starts from lowercase - tennisCoach
public class TennisCoach implements Coach {

	//
	private FortuneService fortuneService;
	private FortuneService fs2;
	
	@Autowired
	//scans spring container for a component that implements
	//FortuneService interface create new of that type and inject here
	//we have 2 classes implementing FortuneService
	//so we need to give exact class name
	//when we have only one class implements interface - spring
	//will found class by himself
	public TennisCoach(HappyFortuneService2 fs2) {
		this.fs2 = fs2;
	}
	
	@Autowired
	public void setFortuneService(HappyFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune()+"\n"+fs2.getFortune();
	}

}
