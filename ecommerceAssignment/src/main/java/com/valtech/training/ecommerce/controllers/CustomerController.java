package com.valtech.training.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.valtech.training.ecommerce.entities.Customer.CustStatus;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.services.ItemService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.vos.CustomerVO;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;
import com.valtech.training.ecommerce.vos.addItemVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/custRegister")
	public String addCustomer(@ModelAttribute CustomerVO customerVO, Model model) {
		customerVO.setCustStatus("ENABLE");
		customerService.addCustomer(customerVO);
		model.addAttribute("customer",customerVO);
		return "order";
	}
	
	@GetMapping("/custRegister")
	public String regCustomer() {
		return "custRegister";
	}
	
	@PostMapping("/item")
	public String addItem(@ModelAttribute ItemVO itemVO, Model model) {
		itemVO.setCurrQuantity(itemVO.getMaxQuantity());
		itemService.addOrUpdateItem(itemVO);
		model.addAttribute("item",itemVO);
		return "order";
	}
	
	@GetMapping("/item")
	public String addCustomer() {
		return "item";
	}
	
}
