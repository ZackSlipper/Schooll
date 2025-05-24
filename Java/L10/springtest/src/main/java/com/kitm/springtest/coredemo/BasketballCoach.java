package com.kitm.springtest.coredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Practice fast running with ball and try to get points.";
	}

}
