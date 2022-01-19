package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

  private String firstName;
  private String lastName;
  private String country;

  private LinkedHashMap<String, String> countryOptions;

  public Student() {

    countryOptions = new LinkedHashMap<>();

    countryOptions.put("BR", "Brazil");
    countryOptions.put("UK", "Kingdom");
    countryOptions.put("US", "America");
    countryOptions.put("IN", "India");
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCountry() {
    return country;
  }

  public LinkedHashMap<String, String> getCountryOptions() {
    return countryOptions;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}
