package com.ldg.blog.aop.info;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 에러 advice 주말 숙제!!

@Component
@Aspect
public class LogAdvice {
																//관점 주변	
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	
	@Around("execution(* com.ldg.blog.controller..*Controller.*(..))"
			+" or execution(* com.ldg.blog.service..*Service.*(..))"
			+" or execution(* com.ldg.blog.repository..*Repository.*(..))")
	public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		
		log.info(type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
		log.info("Argument/Parameter : "+Arrays.toString(proceedingJoinPoint.getArgs()));
		log.info("=================>");
		
		return proceedingJoinPoint.proceed();
	}
	
}



