package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Category;
import com.Entity.Product;
import com.FileUploads.FileUploadUtility;
import com.FileUploads.ProductValidator;
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
			if(operation.equals("category"))
				mv.addObject("message","Category is successfully added");

		}
		return mv;
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView getProductDetails(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("home");	
		
		
		
		List<Category> list = categoryService.getCategoryList();
		
		mv.addObject("categoryList",list);
		mv.addObject("title","Manage Products");
		Product p = productService.getProductFromId(id);
		mv.addObject("product",p);

		mv.addObject("userClickManageProduct",true);
		
		return mv;
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product mProduct,BindingResult results, Model model, HttpServletRequest request)
	{
		System.out.println(mProduct.getId()+"/"+mProduct.getName()+"/"+mProduct.getBrand()+"/"+mProduct.getSupplier_id());
		if(mProduct.getId()==0)
			new ProductValidator().validate(mProduct,results);
		else
		{
			if(!mProduct.getFile().getOriginalFilename().equals(""))
				new ProductValidator().validate(mProduct,results);

		}

		if(results.hasErrors())
		{
			
			List<Category> list = categoryService.getCategoryList();
			
			
			model.addAttribute("categoryList",list);
			model.addAttribute("title","Manage Products");		
			model.addAttribute("userClickManageProduct",true);
			
			return "home";
		}
		boolean b;
		if(mProduct.getId()==0)
		{
			mProduct.setSupplier_id(1);
			mProduct.setIsActive(1);
			 b = productService.addProduct(mProduct);
		}
		else
			b = productService.updateProduct(mProduct);

		
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=productAdd";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int id)
	{
		Product p = productService.getProductFromId(id);
		int isActive = p.getIsActive();
		int val=0;
		if(isActive == 1)
			val=0;
		else
			val=1;
		
		p.setIsActive(val);
		
		productService.updateProduct(p);
		
		String s ="";
		if(val==0)
			s+= "you have successfully deactivated product with id = "+p.getId();
		else
			s+= "you have successfully activated product with id = "+p.getId();
		
		return s;
		
	}
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}

	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategoryRequest(@ModelAttribute Category category)
	{
		categoryService.addCategory(category);
		return "redirect:/manage/products?operation=category";
	}
	
}
