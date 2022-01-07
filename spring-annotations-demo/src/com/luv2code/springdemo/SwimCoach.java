package com.luv2code.springdemo;

public class SwimCoach implements Coach {

  FortuneService fortuneService;

  SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
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
