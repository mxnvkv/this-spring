package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

  @Autowired
  @Qualifier("luckyFortuneService")
  FortuneService fortuneService;

  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practise";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
