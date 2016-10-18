package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService3 implements FortuneService {

	@Override
	public String getFortune() {
		return "HappyFortuneService3 - Today is your lucky day!";
	}

}
