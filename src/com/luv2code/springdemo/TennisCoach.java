package com.luv2code.springdemo;

public class TennisCoach implements Coach {

  @Override
  public String getDailyWorkout() {
    return "Spend 45 minutes on practising serve";
  }

}
