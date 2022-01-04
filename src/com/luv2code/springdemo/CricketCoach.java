package com.luv2code.springdemo;

public class CricketCoach implements Coach {

  FortuneService fortuneService;

  public CricketCoach() {
    System.out.println("Inside no-arg constructor");
  }

  public void setFortuneService(FortuneService fortuneService) {
    System.out.println("Inside setter");
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Practise fast bowling for 15 minutes";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
