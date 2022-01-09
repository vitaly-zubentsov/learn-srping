package com.zubentsov.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/loginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/accessDeniedPage")
	public String showAccessDeniedPage() {
		return "access-denied";
	}
}
