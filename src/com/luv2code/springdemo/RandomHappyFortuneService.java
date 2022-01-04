package com.luv2code.springdemo;

public class RandomHappyFortuneService implements FortuneService {

  private final String[] fortunesArray = {
    "You will have a great promotion in the near future!",
    "You will meet your love soon!",
    "You will will win the trophy this season!",
  };

  @Override
  public String getFortune() {
    int randomIndex = (int) (Math.random() * fortunesArray.length);

    return fortunesArray[randomIndex];
  }

}
