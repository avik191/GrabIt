package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	protected ModelAndView homePage() throws Exception
	{
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","Home");
		modelAndView.addObject("isHome",true);
		return modelAndView;
	}
	
	@RequestMapping(value="/about")
	protected ModelAndView about()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","About");
		modelAndView.addObject("isAbout",true);
		return modelAndView;
	}
	
	@RequestMapping(value="/allproducts")
	protected ModelAndView products()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","Products");
		modelAndView.addObject("isProducts",true);
		return modelAndView;
	}
	
	@RequestMapping(value="/contact")
	protected ModelAndView contact()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","Contact");
		modelAndView.addObject("isContact",true);
		return modelAndView;
	}
}
