package com.surendra.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistrationExceptionHandler {
	@ExceptionHandler(RegistrationException.class)
	public String handleException()
	{
		return "er";
	}

}
