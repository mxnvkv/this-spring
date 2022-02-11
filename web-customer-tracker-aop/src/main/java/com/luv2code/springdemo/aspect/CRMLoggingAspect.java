package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

  // setup logger
  private Logger logger = Logger.getLogger(getClass().getName());

  // setup pointcut declarations
  @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
  private void forControllerPackage() { }

  // do the same for service and DAO
  @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
  private void forServicePackage() { }

  @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
  private void forDaoPackage() { }

  @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
  private void forAppFlow() { }

  // add @Before advice
  @Before("forAppFlow()")
  public void before(JoinPoint joinPoint) {
    // display method we are calling
    String method = joinPoint.getSignature().toShortString();
    logger.info("=====>> in @Before: calling method: " + method);

    // display the arguments to the method

    // get the arguments
    Object[] arguments = joinPoint.getArgs();

    // loop through and display arguments
    for (Object argument : arguments) {
      logger.info("=====>> argument: " + argument);
    }
  }

  // add @AfterReturning advice
  @AfterReturning(
    pointcut = "forAppFlow()",
    returning = "result"
  )
  public void afterReturning(JoinPoint joinPoint, Object result) {
    // display method we are returning from
    String method = joinPoint.getSignature().toShortString();
    logger.info("=====>> in @AfterReturning: from method: " + method);

    // display data returned
    logger.info("=====>> result: " + result);
  }

}
