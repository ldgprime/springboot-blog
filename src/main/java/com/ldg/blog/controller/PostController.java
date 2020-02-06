package com.ldg.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PostController {
	
	@GetMapping({"/","","/post"})
	public String posts() {
		return "/post/list";
	}
	
	@GetMapping("/post/{id}")
	public String post() {
		return "/post/detail";
	}
	
	@GetMapping("/post/write")
	public String write() {
		return "/post/write";
	}
	
	@GetMapping("/post/update/{id}")
	public String update() {
		return "/post/update";
	}
	
	
}
