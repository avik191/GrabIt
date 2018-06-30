package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CategoryDAO;
import com.Entity.Category;
import com.Entity.Product;
import com.Service.CategoryService;
import com.Service.ProductService;

@Controller
public class WebController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
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

		
		List<Product> list= productService.getActiveProductFromCategory(5);
		System.out.println(list.size());


		
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
