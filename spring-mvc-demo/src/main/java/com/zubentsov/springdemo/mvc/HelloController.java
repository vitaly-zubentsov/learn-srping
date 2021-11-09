package com.zubentsov.springdemo.mvc;

import org.springframework.stereotype.Controller;
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
		return "helloworld";
	}
	
	
}
