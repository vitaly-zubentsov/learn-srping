package com.zubentsov.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	//add method to show student form
	@RequestMapping("/student-form")
	public String showForm(Model theModel) {
		
		Student student = new Student();
		theModel.addAttribute("student", student);
		
		return "student-form";
	}
	
	//method to process student form and show result
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
	
		
		return "student-confirmation";
	}
}
