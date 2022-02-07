package com.luv2code;

import com.luv2code.aopdemo.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {

    // read spring config java class
    AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

    // get membership bean from spring container
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

    // call the business method
    accountDAO.addAccount();

    // call the membership business method
    membershipDAO.addSillyMember();

    // close the context
    context.close();

  }

}
