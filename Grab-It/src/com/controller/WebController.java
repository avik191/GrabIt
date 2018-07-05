package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CategoryDAO;
import com.Entity.Address;
import com.Entity.Cart;
import com.Entity.Category;
import com.Entity.Login;
import com.Entity.Product;
import com.Entity.User;
import com.Entity.UserModel;
import com.Exceptions.ProductNotFoundException;
import com.Service.CategoryService;
import com.Service.ProductService;
import com.Service.UserService;

@Controller
public class WebController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	protected ModelAndView homePage() throws Exception {

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("isHome", true);
		modelAndView.addObject("categories", categoryService.getCategoryList());
		return modelAndView;
	}

	// testing urls
	@RequestMapping(value = { "/test" })
	protected ModelAndView addCategory() throws Exception {

		User user = new User();
		user.setFirstName("Shikhar");
		user.setLastName("Dhawan");
		user.setEmail("sd@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("12345");

		// Cart cart = new Cart();
		// cart.setUser(user);

		userService.addUser(user);

		Address address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(1);
		address.setUserID(user.getId());

		userService.addAddress(address);

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("isHome", true);
		modelAndView.addObject("categories", categoryService.getCategoryList());
		return modelAndView;
	}

	//
	@RequestMapping(value = "/about")
	protected ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "About");
		modelAndView.addObject("isAbout", true);
		return modelAndView;
	}

	@RequestMapping(value = "/all/Products")
	protected ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Products");
		modelAndView.addObject("categories", categoryService.getCategoryList());
		modelAndView.addObject("isAllProducts", true);
		return modelAndView;
	}

	@RequestMapping(value = "/category/{id}/products")
	protected ModelAndView categoryProducts(@PathVariable("id") int id) {

		// Fetch single category
		Category category = categoryService.getCategoryFromId(id);

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", category.getName());
		modelAndView.addObject("category", category);
		modelAndView.addObject("categories", categoryService.getCategoryList());
		modelAndView.addObject("isCategoryProduct", true);
		return modelAndView;
	}

	@RequestMapping(value = "/contact")
	protected ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Contact");
		modelAndView.addObject("isContact", true);
		return modelAndView;
	}

	@RequestMapping(value = { "/show/{id}/product" })
	protected ModelAndView ProductPage(@PathVariable("id") int id) throws ProductNotFoundException {
		Product product = productService.getProductFromId(id);
		if (product == null)
			throw new ProductNotFoundException("error");
		product.setViews(product.getViews() + 1);
		boolean b = productService.updateProduct(product);
		System.out.println(b + " product updated");

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", product.getName());
		modelAndView.addObject("showProductPage", true);
		modelAndView.addObject("product", product);
		return modelAndView;
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	protected ModelAndView signIn(@RequestParam(name = "operation", required = false) String operation) {

		Login login = new Login();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Login/Register");
		modelAndView.addObject("login", login);
		modelAndView.addObject("userClickSignIn", true);

		if (operation != null) {
			if (operation.equals("invalid"))
				modelAndView.addObject("message", "Invalid User");
			if (operation.equals("success"))
				modelAndView.addObject("message", "Valid User");
			if (operation.equals("addressSuccess"))
				modelAndView.addObject("message", "Address added");
			if (operation.equals("failure"))
				modelAndView.addObject("message", "Address not added");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/handle/login")
	protected String handleLogin(@Valid @ModelAttribute("login") Login login, BindingResult results, Model model,
			HttpServletRequest request) {
		if (results.hasErrors()) {
			model.addAttribute("title", "Login/Register");
			model.addAttribute("userClickSignIn", true);

			return "home";
		}

		User user = userService.getUserFromEmail(login.getEmail());
		if (user == null) {
			return "redirect:/signIn?operation=invalid";
		} else {
			if (
				login.getPassword().equals(user.getPassword()))
				{
					UserModel userModel = new UserModel();
					userModel.setId(user.getId());
					userModel.setFirstName(user.getFirstName());
					userModel.setLastName(user.getLastName());
					userModel.setRole(user.getRole());
					
					if(user.getRole().equals("USER"))
					{
						Cart cart = userService.getCartFromUserId(user.getId());
						userModel.setCart(cart);
					}
					
					Address address = userService.getBillingAddressFromUserId(user.getId());					
					userModel.setAddress(address);
					
					HttpSession session = request.getSession(true);
					session.setAttribute("loggedUser", userModel);
					
					return "redirect:/home";

				}
			else
			{
				return "redirect:/signIn?operation=invalid";
			}
		}

	}
	
	

	@RequestMapping(value = "/register/user")
	protected ModelAndView RegisterUser(@RequestParam(name = "operation", required = false) String operation) {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Login/Register");
		modelAndView.addObject("user", user);
		modelAndView.addObject("userClickRegister", true);

		if (operation != null) {
			if (operation.equals("invalid"))
				modelAndView.addObject("message", "Not Registered");
			if (operation.equals("success"))
				modelAndView.addObject("message", "Registered");

		}
		return modelAndView;

	}

	@RequestMapping(value = "/handle/register")
	protected String handleRegister(@Valid @ModelAttribute("user") User mUser, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("title", "Login/Register");
			model.addAttribute("userClickRegister", true);

			return "home";
		}
		boolean b = userService.addUser(mUser);

		if(mUser.getRole().equals("USER"))
		{
			Cart cart = new Cart();
			cart.setUserId(mUser.getId());

			boolean f = userService.addCart(cart);
		}
		

		if (b)
			return "redirect:/register/user/address/" + mUser.getId();
		else
			return "redirect:/register/user?operation=invalid";

	}

	@RequestMapping(value = "/register/user/address/{user_id}")
	protected ModelAndView RegisterUser(@PathVariable("user_id") int id) {
		Address address = new Address();
		address.setUserID(id);
		address.setBilling(1);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "Login/Register");
		modelAndView.addObject("address", address);
		modelAndView.addObject("userClickAddress", true);

		return modelAndView;

	}

	@RequestMapping(value = "/handle/address")
	protected String handleAddress(@Valid @ModelAttribute("address") Address mAddress, BindingResult results,
			Model model) {
		if (results.hasErrors()) {
			model.addAttribute("title", "Login/Register");
			model.addAttribute("userClickAddress", true);

			return "home";
		}
		boolean b = userService.addAddress(mAddress);

		if (b)
			return "redirect:/signIn?operation=addressSuccess";
		else
			return "redirect:/signIn?operation=failure";

	}

	@RequestMapping(value = "/unauthorizedAccess")
	protected ModelAndView controlAccess() {

		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorTitle", "Uha CAught you !!!");
		modelAndView.addObject("description", "You dont have access to this page...");
		modelAndView.addObject("title", "unauthorizedAccess");
		return modelAndView;

	}
}
