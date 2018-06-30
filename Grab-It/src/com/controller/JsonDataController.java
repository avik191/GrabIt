package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Entity.Product;
import com.Service.ProductService;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		List<Product> list = productService.getActiveProducts();
		return list;
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsFromCategory(@PathVariable("id") int id)
	{
		List<Product> list = productService.getActiveProductFromCategory(id);
		return list;
	}

}
