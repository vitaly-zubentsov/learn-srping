package com.zubentsov.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zubentsov.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	List<Employee> employees;
	
	@PostConstruct
	public void loadData() {
		employees = new ArrayList<>();
		
		employees.add(new Employee(1,"Dan","Smith","sithdan@ya.ru"));
		employees.add(new Employee(1,"Petr","Petrov","pp@ya.ru"));
		employees.add(new Employee(1,"Ivan","Ivanov","IvanI@ya.ru"));
	}

	@GetMapping("/list")
	public String showEmployees(Model model) {
		
		model.addAttribute("employees", employees);
		
		return "list-employees";
	}
}
