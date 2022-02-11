package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
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

  // add @AfterReturning advice

}
