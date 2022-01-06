package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

  private Random random = new Random();
  private String[] fortunes = {
    "Beware of the wolf in sheep's clothing",
    "Diligence is the mother of good luck",
    "The journey is the reward"
  };

  @Override
  public String getFortune() {
    int randomIndex = random.nextInt(fortunes.length);

    return fortunes[randomIndex];
  }

}
