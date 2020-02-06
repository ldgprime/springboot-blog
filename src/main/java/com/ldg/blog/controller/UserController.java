package com.ldg.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/join")	
	public String join() {
		return "/user/join";
	}
	
	@GetMapping("/user/login")	
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/user/profile/{id}")	
	public String update() {
		return "/user/profile";
	}
	
}
