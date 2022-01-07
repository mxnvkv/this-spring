package com.luv2code.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// added @Component instead of @Configuration
@Configuration
@ComponentScan("com.luv2code.springdemo")
public class BaseballConfig {

}
