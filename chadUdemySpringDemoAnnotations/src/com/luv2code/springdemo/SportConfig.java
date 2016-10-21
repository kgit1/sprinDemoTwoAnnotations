package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// tell spring that it is java configuration
@ComponentScan("com.luv2code.springdemo")
// tell spring where to scan for components
//can be missing if all our needed components here and
//all of them manually defined 
public class SportConfig {

	@Bean
	// define bean for our SadFortuneService
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	//define bean for our SwimCoach and inject dependecy
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());		
	}
}
