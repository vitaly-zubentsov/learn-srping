package com.zubentsov.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zubentsov.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
	EmployeeService employeeService;
	
	@Autowired
	EmployeeController (EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	@GetMapping("/list")
	public String showEmployees(Model model) {
		
		model.addAttribute("employees", employeeService.findAll());
		
		return "list-employees";
	}
}
