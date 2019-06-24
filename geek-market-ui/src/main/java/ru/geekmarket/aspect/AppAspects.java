package ru.geekmarket.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AppAspects {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html
    // https://www.baeldung.com/spring-aop-annotation
    // https://www.baeldung.com/spring-aop
    @Before("execution(* ru.geekmarket.controller.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Call of {}", joinPoint);
    }

    @Around("@annotation(ru.geekmarket.aspect.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);

        return result;
    }
}
