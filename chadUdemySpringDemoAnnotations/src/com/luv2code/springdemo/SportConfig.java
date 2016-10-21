package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// tell spring that it is java configuration
@ComponentScan("com.luv2code.springdemo")
// tell spring where to scan for components
//can be missing if all our needed components here and
//all of them manually defined 
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//add support to resolve ${...} properties
	
	@Bean 
	public static PropertySourcesPlaceholderConfigurer
	propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}	
	
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
	
	//practice activity
	//define and inject beans
	@Bean
	public FortuneService newFortuneService(){
		return new NewFortuneService();
	}
	
	@Bean
	public GamingCoach gamingCoach(){
		return new GamingCoach(newFortuneService());
	}
}
