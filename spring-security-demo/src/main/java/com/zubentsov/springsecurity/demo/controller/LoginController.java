package com.zubentsov.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping
	public String showMyLoginPage() {
		return "plain-login";
	}
}
