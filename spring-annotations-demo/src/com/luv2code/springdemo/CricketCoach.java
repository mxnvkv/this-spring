package com.luv2code.springdemo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CricketCoach implements Coach {

  private FortuneService fortuneService;

  @Autowired
  public CricketCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practise";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
