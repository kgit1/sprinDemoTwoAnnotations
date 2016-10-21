package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoJavaConfigApp {

	public static void main(String[] args) {
		// read spring config file
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		// Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		// get bean with default name
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		SwimCoach alphaCoach = context.getBean("swimCoach", SwimCoach.class);
		GamingCoach gamingCoach = context.getBean("gamingCoach", GamingCoach.class);
		// call a method on the bean
		System.out.println("theCoach =============================");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		System.out.println("======================================");
		System.out.println("alphaCoach ===========================");
		System.out.println(alphaCoach.getDailyWorkout());
		System.out.println(alphaCoach.getDailyFortune());
		System.out.println(alphaCoach.getClass().getSimpleName() 
				+ "\nemail: " + alphaCoach.getEmail()
				+ "\nteam: " + alphaCoach.getTeam());
		
		System.out.println("======================================");
		System.out.println("Practice activity open");
		System.out.println("GamingCoach===========================");
		System.out.println(gamingCoach.getDailyWorkout());
		System.out.println(gamingCoach.getDailyFortune());
		System.out.println("Practice activity close");
		System.out.println("======================================");
		
		// close the context
		context.close();
	}

}
