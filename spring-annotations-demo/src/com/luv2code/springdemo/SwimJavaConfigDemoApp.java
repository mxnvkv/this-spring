package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
  public static void main(String[] args) {

    // read spring config file
    AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(SportConfig.class);

    // get the bean from spring container
    Coach coach = context.getBean("swimCoach", Coach.class);

    // call a method on bean
    System.out.println(coach.getDailyWorkout());

    System.out.println(coach.getDailyFortune());

    // close the context
    context.close();


  }
}
