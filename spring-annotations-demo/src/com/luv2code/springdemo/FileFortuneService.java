package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

  private Random random = new Random();
  private String filePath = "src/fortunes.txt";
  private List<String> fortunes = new ArrayList<>();

  public FileFortuneService() {

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;

      while((line = reader.readLine()) != null) {
        fortunes.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getFortune() {
    int randomIndex = random.nextInt(fortunes.size());

    return fortunes.get(randomIndex);
  }

}
