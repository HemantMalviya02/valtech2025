package com.valtech.training.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.springweb.vos.loginVO;

@Controller
public class HelloController {
	
//	public ModelAndView test() {
//		int x = 0;
//		ModelAndView view = new ModelAndView(x == 0 ? "error" : "login");
//		view.addObject("message", "Please use login Dialog");
//		return view;
//	}
	
//	preferred way down
	
	@PostMapping("/login")
	public String handleLoginForm(@ModelAttribute loginVO login, Model model) {
		if("scott".equals(login.getUsername()) && "tiger".equals(login.getPassword())) {
			model.addAttribute("login", login);
			return "dashboard";
		}
		model.addAttribute("message", "Invalid Username Password");
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "HelloSpringWeb.";
	}
}
