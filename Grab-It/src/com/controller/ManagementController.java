package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Category;
import com.Entity.Product;
import com.Service.CategoryService;
import com.Service.ProductService;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name="operation",required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("home");	
		
		Product p = new Product();
		
		List<Category> list = categoryService.getCategoryList();
		
		mv.addObject("product",p);
		mv.addObject("categoryList",list);
		mv.addObject("title","Manage Products");		
		mv.addObject("userClickManageProduct",true);
		
		if(operation!=null)
		{
			if(operation.equals("productAdd"))
				mv.addObject("message","Product is successfully added");

		}
		return mv;
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product mProduct,BindingResult results, Model model)
	{

		if(results.hasErrors())
		{
			
			List<Category> list = categoryService.getCategoryList();
			
			
			model.addAttribute("categoryList",list);
			model.addAttribute("title","Manage Products");		
			model.addAttribute("userClickManageProduct",true);
			
			return "home";
		}
		
		mProduct.setSupplier_id(1);
		mProduct.setIsActive(1);
		boolean b = productService.addProduct(mProduct);
		System.out.println(mProduct.getName()+"/"+mProduct.getCategory_id());
		
		return "redirect:/manage/products?operation=productAdd";
	}
	
}
