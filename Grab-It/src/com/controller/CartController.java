package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Cart;
import com.Entity.CartLine;
import com.Entity.Product;
import com.Entity.UserModel;
import com.Service.CartLineService;
import com.Service.ProductService;
import com.Service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartLineService cartLineService;
	@Autowired
	UserService userService;
	@Autowired
	HttpSession session;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/show")
	protected ModelAndView about(@RequestParam(name = "result", required = false) String result) {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "User Cart");
		modelAndView.addObject("userClickShowCart", true);
		
		
		
		if(result!=null) {
			switch(result) {
				case "updated":
					modelAndView.addObject("message", "Cart has been updated successfully!");					
					break;
				case "error":
					modelAndView.addObject("message", "Something went wrong");
					break;
				case "deleted":
					modelAndView.addObject("message", "CartLine is removed successfully");
					break;
				case "added":
					modelAndView.addObject("message", "CartLine is added successfully");
					break;
				case "unavailable":
					modelAndView.addObject("message", "Product quantity not available");
					break;
				
			}
		}
		
		
		
		UserModel user = (UserModel) session.getAttribute("loggedUser");
		List<CartLine> list = cartLineService.list(user.getCart().getId());
		List<Product> productList = new ArrayList<Product>();
		
		for(CartLine cart : list)
		{
			Product p = productService.getProductFromId(cart.getProductId());
			productList.add(p);
		}
		
		modelAndView.addObject("cartLines", list);
		modelAndView.addObject("productList", productList);

		return modelAndView;
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String udpateCartLine(@PathVariable int cartLineId, @RequestParam int count) {
		String response = "";
		CartLine cartLine = cartLineService.get(cartLineId);
		if(cartLine == null)
			response = "result=error";
		else
		{
			Product p = productService.getProductFromId(cartLine.getProductId());
			double oldTotal = cartLine.getTotal();
			
			if(p.getQuantity()<count)
			{
				count=p.getQuantity();
				return "redirect:/cart/show?result=unavailable";
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(p.getUnitPrice());
			cartLine.setTotal(count*p.getUnitPrice());
			
			boolean b = cartLineService.update(cartLine);
			System.out.println("cartline updated? "+b);
			
			UserModel user = (UserModel) session.getAttribute("loggedUser");
			Cart cart = user.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-oldTotal+cartLine.getTotal());
			b = userService.updateCart(cart);
			System.out.println("cart updated? "+b);

			
			response = "result=updated";
		}
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String udpateCartLine(@PathVariable int cartLineId) {
		String response = "";
		CartLine cartLine = cartLineService.get(cartLineId);
		if(cartLine == null)
			response = "result=error";
		else
		{
			//update cart
			UserModel user = (UserModel) session.getAttribute("loggedUser");
			Cart cart = user.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-cartLine.getTotal());
			cart.setCartLines(cart.getCartLines()-1);
			boolean b = userService.updateCart(cart);
			System.out.println("cart updated? "+b);
			
			//delete cartline
			 b = cartLineService.remove(cartLine);
			System.out.println("cartline updated? "+b);
			
			

			
			response = "result=deleted";
		}
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addCartLine(@PathVariable int productId) {
		String response = "";
		
		UserModel user = (UserModel) session.getAttribute("loggedUser");
		if(user == null)
		{
			return "redirect:/signIn";
		}
		Cart cart = user.getCart();
		
		CartLine cartLine = cartLineService.getByCartAndProduct(cart.getId(), productId);
		if(cartLine == null)
		{
			// add new cartline
			cartLine = new CartLine();
			
			Product p = productService.getProductFromId(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProductId(productId);
			cartLine.setProductCount(1);
			cartLine.setBuyingPrice(p.getUnitPrice());
			cartLine.setTotal(p.getUnitPrice());
			cartLine.setAvailable(1);
			
			boolean b = cartLineService.add(cartLine);
			System.out.println("cartline added? "+b);
			
			cart.setCartLines(cart.getCartLines()+1);
			cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
			
			b = userService.updateCart(cart);
			System.out.println("cart updated? "+b);
			
			response = "result=added";
		}
		else
		{
		
			Product p = productService.getProductFromId(productId);
			double oldTotal = cartLine.getTotal();
			
			if(p.getQuantity()<cartLine.getProductCount()+1)
			{
				return "redirect:/cart/show?result=unavailable";
			}
			
			cartLine.setProductCount(cartLine.getProductCount()+1);
			cartLine.setBuyingPrice(p.getUnitPrice());
			cartLine.setTotal(cartLine.getProductCount()*p.getUnitPrice());
			
			boolean b = cartLineService.update(cartLine);
			System.out.println("cartline updated? "+b);
			
			
			cart.setGrandTotal(cart.getGrandTotal()-oldTotal+cartLine.getTotal());
			b = userService.updateCart(cart);
			System.out.println("cart updated? "+b);

			
			response = "result=added";
		}
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/review")
	public ModelAndView review()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("isReview",true);
		modelAndView.addObject("title","Review Cart");
		UserModel user = (UserModel) session.getAttribute("loggedUser");
		List<CartLine> list = cartLineService.list(user.getCart().getId());
		List<Product> productList = new ArrayList<Product>();
		
		for(CartLine cart : list)
		{
			Product p = productService.getProductFromId(cart.getProductId());
			productList.add(p);
		}
		
		modelAndView.addObject("cartLines", list);
		modelAndView.addObject("productList", productList);
		return modelAndView;
	}
	
	@RequestMapping("/payment")
	public String payment()
	{
		UserModel user = (UserModel) session.getAttribute("loggedUser");
		List<CartLine> list = cartLineService.list(user.getCart().getId());
		
		for(CartLine cartLine : list)
		{
			cartLineService.remove(cartLine);
		}
		Cart cart = user.getCart();
		cart.setCartLines(0);
		cart.setGrandTotal(0.0);
		userService.updateCart(cart);
		
		return "redirect:/home?result=checkout";
	}
}
