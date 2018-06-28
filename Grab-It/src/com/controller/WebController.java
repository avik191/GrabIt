package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	protected ModelAndView homePage() throws Exception
	{
		
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
}
