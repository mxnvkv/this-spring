package com.luv2code.springdemo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TennisCoach implements Coach {

  FortuneService fortuneService;

  @Autowired
  public TennisCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Practise volley backhand for 15 minutes";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
