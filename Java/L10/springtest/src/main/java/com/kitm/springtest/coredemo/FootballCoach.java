package com.kitm.springtest.coredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class FootballCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Practice fast running with ball and kicking.";
	}

}
