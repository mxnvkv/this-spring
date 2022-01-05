package com.luv2code.springdemo;

public class TrackCoach implements Coach {

  private FortuneService fortuneService;

  TrackCoach() {

  }

  TrackCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public void doMyStartupStuff() {
    System.out.println("TrackCoach: inside method doMyStartupStuff");
  }

  public void doMyCleanupStuffYoYo() {
    System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getDailyFortune() {
    return "Just do it: " + fortuneService.getFortune();
  }

}
