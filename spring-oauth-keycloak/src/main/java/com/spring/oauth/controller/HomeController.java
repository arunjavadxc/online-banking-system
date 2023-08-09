package com.spring.oauth.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Controller
@RequestMapping
public class HomeController {

	/*
	 * @GetMapping(path = "/home") public String index() { return
	 * "forward:/index.html"; }
	 */
	/*
	 * @GetMapping(path = "/customers") public String customers(Principal principal,
	 * Model model) { Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * auth.getAuthorities().forEach(a -> log.info(String.valueOf(a))); return
	 * "customers"; }
	 */
}
