package com.example.naver_week32.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DepartmentAndEmployeeServiceAspect {
    private Logger logger = LoggerFactory.getLogger(DepartmentAndEmployeeServiceAspect.class);

    @Before("execution(* com.example.naver_week32.controller.DepartmentController.getDepartmentDto(..))")
    public void beforeGetDepartmentDto(JoinPoint joinPoint){
        logger.info("Before called " + joinPoint.toString());
    }

    @After("execution(* com.example.naver_week32.controller.DepartmentController.getDepartmentDto(..))")
    public void afterGetDepartmentDto(JoinPoint joinPoint){
        logger.info("After called " + joinPoint.toString());
    }

    @AfterThrowing("execution(* com.example.naver_week32.controller.EmployeeController.getEmployee(..))")
    public void afterGetEmployeeDto(JoinPoint joinPoint){
        logger.info("After called " + joinPoint.toString() + " undone");
    }
}
