package com.kitm.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kitm.springtest.coredemo.Coach;
import com.kitm.springtest.coredemo.FootballCoach;

@Configuration
public class SportConfig {
	@Bean("aquatic")
	public Coach footballCoach() {
		return new FootballCoach();
	}
}
