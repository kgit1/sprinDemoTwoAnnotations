package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
//show spring that we want that component to be registered as bean
@Component
//without explicitly specified bean id - spring will use default component name
//it will be simple class name but starts from lowercase - tennisCoach
//@Scope("prototype") 
//forces spring to produce a new bean instance each time one is needed
//for "prototype" scoped beans, Spring does not call the @PreDestroy method
//initialization lifecycle callback methods are called on all objects 
//regardless of scope, in the case of prototypes, configured destruction 
//lifecycle callbacks are not called.
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	private FortuneService fs2;
	
	@Autowired
	//inject object as a value of field
	//to inject value directly we need only to put autowired annotation
	//on our field, even on private without any setters
	@Qualifier("happyFortuneService3")
	//we have 3 implementations of FortunesService interface and no
	//hint for spring here which to choose 
	//so we use Qualifier annotation to give this hint
	private FortuneService fs3;
	
	@Autowired
	@Qualifier("happyFortuneService4")
	private FortuneService fs4;
	
	@Autowired(required=false)
	//inject value of java type field
	//By default, the autowiring will fail whenever zero candidate beans are
	//available; the default behavior is to treat annotated methods, 
	//constructors, and fields as indicating required dependencies. 
	//This behavior can be changed as demonstrated below.
	private String name = "Bob";
	
	public TennisCoach(){
		System.out.println(getClass().getSimpleName() + ": inside constructor"
				+ " with no fields(empty, default)");
	}	
	
	@Autowired
	//inject object using constructor
	//scans spring container for a component that implements
	//FortuneService interface create new of that type and inject here
	//we have 2 classes implementing FortuneService
	//so we need to give exact class name
	//when we have only one class implements interface - spring
	//will found class by himself
	public TennisCoach(HappyFortuneService2 fs2) {
		System.out.println(getClass().getSimpleName() + ": inside constructor"
				+ " with fields");
		this.fs2 = fs2;
	}
	
	@Autowired
	//inject object using setter
	//actually as long as method has annotation autowired - 
	//it  can have any name, not only setter signature
	public void setFortuneService(HappyFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@PostConstruct
	//define my init method
	//will execute after constructor and after injections of dependencies
	public void doMyStartupStuff(){
		System.out.println(getClass().getSimpleName() + ": inside of "
				+ "doMyStartupStuff method");
	}
	
	@PreDestroy
	//define my destroy method
	//will execute before bean is destroyed
	//for "prototype" scoped beans, Spring does not call the @PreDestroy method.
	public void doMyCleanupStuff(){
		System.out.println(getClass().getSimpleName() + ": inside of "
				+ "doMyCleanupStuff method");
	}
	
	@Override
	public String getDailyWorkout() {
		return getClass().getSimpleName() + name 
				+ ": Practice your backhand volley";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() + "\n" + fs2.getFortune()
		+ "\n" + fs3.getFortune()
		+ "\n" + fs4.getFortune();
	}

}
