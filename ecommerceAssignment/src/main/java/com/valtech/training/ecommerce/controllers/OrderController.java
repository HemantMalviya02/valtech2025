package com.valtech.training.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.ecommerce.services.ItemService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;

@Controller
public class OrderController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public String order(@ModelAttribute ItemVO itemVO , Model model) {
		model.addAttribute("items",itemService.getAllItems());
		return "order";
	}
	
	@PostMapping("/order")
	public String createList(@ModelAttribute OrderVO orderVO, Model model) {
		System.out.println("orderVO in controller"+orderVO);
		orderService.OrderProcess(orderVO);
		return "redirect:/order";
	}
	
	@PostMapping("/orderItem")
	public String createOrder(@ModelAttribute OrderVO orderVO, Model model) {
		orderVO.setStatus("ORDERED");
		orderVO.setCustId(1);
		orderService.OrderProcess(orderVO);
		return "orderItems";
		
	}
}
