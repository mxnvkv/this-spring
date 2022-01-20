package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

  private String firstName;
  private String lastName;
  private String country;
  private LinkedHashMap<String, String> countryOptions;
  private String favoriteLanguage;
  private String[] operatingSystems;

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

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public String[] getOperatingSystems() {
    return operatingSystems;
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

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  public void setOperatingSystems(String[] operatingSystems) {
    this.operatingSystems = operatingSystems;
  }

}
