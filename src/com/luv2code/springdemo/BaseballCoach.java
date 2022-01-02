package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

  // define a private field for the dependency
  private FortuneService fortuneService;

  // define the constructor for dependency injection
  BaseballCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practise";
  }

  @Override
  public String getDailyFortune() {

    // use my fortuneService to get a fortune

    return fortuneService.getFortune();
  }

}
