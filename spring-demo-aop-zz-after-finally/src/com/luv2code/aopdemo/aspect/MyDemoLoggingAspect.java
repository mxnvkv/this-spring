package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  @AfterThrowing(
    pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
    throwing = "exception"
  )
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
    // print out which methods we are advising
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

    // log the exception
    System.out.println("\n=====>>> The exception is: " + exception);
  }

  // add a new advice for @AfterReturning on the findAccounts method
  @AfterReturning(
    pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
    returning = "result"
  )
  public void afterReturningFindAccountsAdvice(
    JoinPoint joinPoint,
    List<Account> result
  ) {
    // print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

    // print out the results of the method call
    System.out.println("\n=====>>> result is: " + result);

    // let's post-process the data ... let's modify it :-)

    // convert the account names to uppercase
    convertAccountNamesToUppercase(result);

    System.out.println("\n=====>>> result is: " + result);
  }

  @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    // display the method signature
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

    System.out.println("Method: " + methodSignature);

    // display method arguments

    // get args
    Object[] args = joinPoint.getArgs();

    // loop through args
    for (Object arg : args) {
      System.out.println(arg);

      if (arg instanceof Account) {
        // downcast and print account specific stuff
        Account account = (Account) arg;

        System.out.println("account name: " + account.getName());
        System.out.println("account level: " + account.getLevel());
      }
    }
  }

  private void convertAccountNamesToUppercase(List<Account> result) {
    // loop through accounts
    for (Account account : result) {
      // get uppercase version of name
      String nameToUppercase = account.getName().toUpperCase();

      // update the name on the account
      account.setName(nameToUppercase);
    }
  }

}
