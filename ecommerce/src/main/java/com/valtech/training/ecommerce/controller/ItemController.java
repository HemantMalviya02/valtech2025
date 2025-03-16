package com.valtech.training.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.valtech.training.ecommerce.services.ItemService;
import com.valtech.training.ecommerce.vos.ItemVO;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/orders")
	public String orderPage(Model model)  {
		model.addAttribute("item", itemService.getAll());
		return "order";
	}
	
	@PostMapping("/items")
	public String addItem(@ModelAttribute ItemVO item, Model model) {
		model.addAttribute("item", item);
		itemService.saveOrUpdate(item);
		return "redirect:/orders";
	}
	
	@GetMapping("/items")
	public String itemPage() {
		return "item";
	}
}
