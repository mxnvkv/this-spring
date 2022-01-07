package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

  FortuneService fortuneService;

  @Value("${foo.email}")
  private String email;

  @Value("${foo.team}")
  private String team;

  SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public String getEmail() {
    return email;
  }

  public String getTeam() {
    return team;
  }

  @Override
  public String getDailyWorkout() {
    return "Swim 1000 meters as a warm up";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
