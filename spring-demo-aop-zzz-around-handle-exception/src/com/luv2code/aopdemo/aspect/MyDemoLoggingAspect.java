package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  private static Logger logger =
    Logger.getLogger(MyDemoLoggingAspect.class.getName());

  @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    // print out which methods we are advising on
    String method = proceedingJoinPoint.getSignature().toShortString();
    logger.info("\n=====>>> Executing @Around on method: " + method);

    // get begin timestamp
    long start = System.currentTimeMillis();

    // now, let's execute the method
    Object result = null;

    try {
      result = proceedingJoinPoint.proceed();
    } catch (Exception e) {
      // log the exception
      logger.warning(e.getMessage());

      // rethrow exception
      throw e;
    }

    // get end timestamp
    long end = System.currentTimeMillis();

    // compute duration and display it
    long duration = end - start;
    logger.info("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

    return result;
  }

  @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
    // print out which methods we are advising
    String method = joinPoint.getSignature().toShortString();
    logger.info("\n=====>>> Executing @After (finally) on method: " + method);
  }

  @AfterThrowing(
    pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
    throwing = "exception"
  )
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
    // print out which methods we are advising
    String method = joinPoint.getSignature().toShortString();
    logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);

    // log the exception
    logger.info("\n=====>>> The exception is: " + exception);
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
    logger.info("\n=====>>> Executing @AfterReturning on method: " + method);

    // print out the results of the method call
    logger.info("\n=====>>> result is: " + result);

    // let's post-process the data ... let's modify it :-)

    // convert the account names to uppercase
    convertAccountNamesToUppercase(result);

    logger.info("\n=====>>> result is: " + result);
  }

  @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    logger.info("\n=====>>> Executing @Before advice on addAccount()");

    // display the method signature
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

    logger.info("Method: " + methodSignature);

    // display method arguments

    // get args
    Object[] args = joinPoint.getArgs();

    // loop through args
    for (Object arg : args) {
      logger.info(arg.toString());

      if (arg instanceof Account) {
        // downcast and print account specific stuff
        Account account = (Account) arg;

        logger.info("account name: " + account.getName());
        logger.info("account level: " + account.getLevel());
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
