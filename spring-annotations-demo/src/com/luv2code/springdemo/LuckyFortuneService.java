package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class LuckyFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "You will find a true love!";
  }

}
