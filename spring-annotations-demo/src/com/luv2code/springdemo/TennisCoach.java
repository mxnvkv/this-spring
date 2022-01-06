package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

  @Autowired
  @Qualifier("fileFortuneService")
  private FortuneService fortuneService;

  public TennisCoach() {
    System.out.println(">> TennisCoach: inside default constructor");
  }

  // @Autowired
  // public TennisCoach(FortuneService fortuneService) {
  //   this.fortuneService = fortuneService;
  // }

  // @Autowired
  // public void doSomeCrazyStuff(FortuneService fortuneService) {
  //   System.out.println(">> TennisCoach: inside doSomeCrazyStuff");
  //   this.fortuneService = fortuneService;
  // }

  @PostConstruct
  public void doMyStartupStuff() {
    System.out.println(">> TennisCoach: inside doMyStartupStuff()");
  }

  @PreDestroy
  public void doMyCleanupStuff() {
    System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
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
