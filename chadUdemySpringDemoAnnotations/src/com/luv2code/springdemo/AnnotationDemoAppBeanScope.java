package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoAppBeanScope {

	public static void main(String[] args) {
		//load spring config file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		//@Scope("prototype") annotation in TennisCoach class forces spring
		//to produce a new bean instance each time one is needed
		//if no scope defined - default is @Scope("singleton") 
		
		//check if beans are the same, pointing to same area of memory
		boolean result = (theCoach==alphaCoach);
		System.out.println("Pointing to the same object: " + result);
		
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for theCoach: " + alphaCoach);
		
		System.out.println("theCoach =============================");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("alphaCoach ===========================");
		System.out.println(alphaCoach.getDailyWorkout());
		System.out.println(alphaCoach.getDailyFortune());
		
		//close the context!
		context.close();
	}

}
