package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

  private String name;
  private String serviceCode;

  public boolean addAccount(Account account, boolean vipFlag) {
    System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    return true;
  }

  public boolean doWork() {
    System.out.println(getClass() + ": doWork()");

    return false;
  }

  public String getName() {
    System.out.println(getClass() + ": getName()");

    return name;
  }

  public String getServiceCode() {
    System.out.println(getClass() + ": getServiceCode()");

    return serviceCode;
  }

  public void setName(String name) {
    System.out.println(getClass() + ": setName()");

    this.name = name;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + ": setServiceCode()");

    this.serviceCode = serviceCode;
  }
}
