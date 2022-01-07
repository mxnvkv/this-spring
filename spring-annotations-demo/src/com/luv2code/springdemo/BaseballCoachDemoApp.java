package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BaseballCoachDemoApp {
  public static void main(String[] args) {

    // used "baseballConfig" instead of BaseballConfig.class
    AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(BaseballConfig.class);

    Coach coach = context.getBean("baseballCoach", Coach.class);

    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());

  }
}
