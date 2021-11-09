package com.zubentsov.springdemo.mvc;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	//method to show hello-world form
	
	@RequestMapping("helloworld-form")
	public String helloWorldForm() {
		return "helloworld-form";
	}
	
	//method to create and show hello world page
	
	@RequestMapping("processForm")
	public String helloWorld() {
		return "helloworld-show";
	}
	
	//new process form method using model data
	@RequestMapping("processFormSecond")
	public String shoutHelloWorld(HttpServletRequest request, Model model) {
		
		String result = "Yo! " + request.getParameter("studentName").toUpperCase();
		
		
		model.addAttribute("message",result);
		
		
		return "helloworld-show";
	}
	
}
