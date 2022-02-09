package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

    // call method to find the accounts
    List<Account> accounts = null;

    try {
      accounts = accountDAO.findAccounts();
    } catch (Exception e) {
      System.out.println("\nMain Program ... caught exception: " + e);
    }

    // display the accounts
    System.out.println("\nMain Program: AfterThrowingDemoApp");
    System.out.println("----");

    System.out.println(accounts);

    System.out.println("\n");

    // close the context
    context.close();
  }

}
