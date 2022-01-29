package com.zubentsov.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String helloWorld(Model model) {
		
		model.addAttribute("date", new Date());
		
		return "helloworld";
	}
}
