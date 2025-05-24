package com.kitm.springtest.coredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside doMyStartupStuff()");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside doMyCleanupStuff()");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley.";
	}

}
