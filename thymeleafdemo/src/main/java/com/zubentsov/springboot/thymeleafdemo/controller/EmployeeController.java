package com.zubentsov.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubentsov.springboot.thymeleafdemo.entity.Employee;
import com.zubentsov.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	EmployeeService employeeService;

	@Autowired
	EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String showEmployees(Model model) {

		model.addAttribute("employees", employeeService.findAll());

		return "/employees/employees-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "/employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model model) {
		
		Employee employee = employeeService.findById(employeeId);
		
		model.addAttribute("employee", employee);
		
		return "/employees/employee-form";
	}
	

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveOrUpdate(employee);
		// use redirect to prevent duplicate suSbmissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@ModelAttribute("employeeId") int employeeId) {
		employeeService.delete(employeeId);
		// use redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
}
