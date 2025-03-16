package com.valtech.training.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.vos.CustomerVO;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	public ModelAndView test() {
		ModelAndView view = new ModelAndView("register");
		view.addObject("message", "Pls use login dialogue");
		return view;
	}
	
	
	@PostMapping("/register")
	public String addCustomer(@ModelAttribute CustomerVO customer, Model model) {
		model.addAttribute("customer", customer);
		customerService.saveOrUpdate(customer);
		return "registercustomer";
		
	}
	
	
	@GetMapping("/register")
	public String registerPage() {
		return "registercustomer";
	}
}
