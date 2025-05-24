package com.kitm.springtest.coredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
	
	private Coach myCoach;

	@Autowired()
	public void setCoach(@Qualifier("tennisCoach") Coach coach) {
		myCoach = coach;
	}
	/*public CoachController(Coach coach) {
		myCoach = coach;
	}*/

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
