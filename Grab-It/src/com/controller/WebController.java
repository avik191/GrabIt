package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CategoryDAO;
import com.Entity.Category;
import com.Service.CategoryService;

@Controller
public class WebController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	protected ModelAndView homePage() throws Exception
	{
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","Home");
		modelAndView.addObject("isHome",true);
		modelAndView.addObject("categories",categoryService.getCategoryList());
		return modelAndView;
	}
	
	// testing urls
	@RequestMapping(value = {"/test"})
	protected ModelAndView addCategory() throws Exception
	{
		Category category;
		category = new Category();
		category.setName("Xbox");
		category.setDescription("Xbox here");
		category.setImageURL("Xbox.png");
		boolean b = categoryService.addCategory(category);
		System.out.println(b+" category added");
		
		Category category2 = categoryService.getCategoryFromId(3);
		System.out.println(category2.getName());
		
		Category category3 = categoryService.getCategoryFromId(4);
		category3.setImageURL("tv.png");
		b = categoryService.updateCategory(category3);
		System.out.println(b+" category updated");
		
		Category category4 = categoryService.getCategoryFromId(8);
		category4.setActive(0);
		b = categoryService.updateCategory(category4);
		System.out.println(b+" category deleted");

		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","Home");
		modelAndView.addObject("isHome",true);
		modelAndView.addObject("categories",categoryService.getCategoryList());
		return modelAndView;
	}
	//
	@RequestMapping(value="/about")
	protected ModelAndView about()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","About");
		modelAndView.addObject("isAbout",true);
		return modelAndView;
	}
	
	@RequestMapping(value="/all/Products")
	protected ModelAndView allProducts()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","Products");
		modelAndView.addObject("categories",categoryService.getCategoryList());
		modelAndView.addObject("isAllProducts",true);
		return modelAndView;
	}
	
	@RequestMapping(value="/category/{id}/products")
	protected ModelAndView categoryProducts(@PathVariable("id") int id)
	{
		
		//Fetch single category
		Category category = categoryService.getCategoryFromId(id);
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title",category.getName());
		modelAndView.addObject("category",category);
		modelAndView.addObject("categories",categoryService.getCategoryList());
		modelAndView.addObject("isCategoryProduct",true);
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
