package com.spring.oauth.controller;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

	@GetMapping(path = "/")
	public String index() {
		return "external";
	}

	@GetMapping(path = "/customers")
	public String customers(Principal principal, Model model) {
		return "customers";
	}
}
