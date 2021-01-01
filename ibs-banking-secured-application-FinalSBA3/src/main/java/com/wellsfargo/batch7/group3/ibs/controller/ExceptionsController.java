package com.wellsfargo.batch7.group3.ibs.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.group3.ibs.exception.IBSExceptionHandler;


@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(IBSExceptionHandler.class)
	public ModelAndView handleException(IBSExceptionHandler exp) {
		return new ModelAndView("error-page", "errMsg",exp.getMessage());
	}
}
