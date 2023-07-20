package com.mz.bdleather.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.mz.bdleather.controller.*)")
	public void packagePointer() {
		///to decide the point of execution
	}
    @After("packagePointer()")
    public void beforeLog() {
    	log.debug("********************************************/////***********");
    }
}
