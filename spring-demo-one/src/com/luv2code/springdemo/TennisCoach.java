package com.luv2code.springdemo;

public class TennisCoach implements Coach {

  private FortuneService fortuneService;

  TennisCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 45 minutes on practising serve";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
