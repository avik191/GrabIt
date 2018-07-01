package com.Exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleHandlerNotFound()
	{
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorTitle","No Such Page Found");
		modelAndView.addObject("description","The page you are looking now is not available now");
		modelAndView.addObject("title","404 error page");
		return modelAndView;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFound()
	{
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorTitle","Product not Available");
		modelAndView.addObject("description","The product you are looking now is not available now");
		modelAndView.addObject("title","product unavailable");
		return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorTitle","Contact your Administrator");
		modelAndView.addObject("description",sw.toString());
		modelAndView.addObject("title","error");
		return modelAndView;
	}
}
