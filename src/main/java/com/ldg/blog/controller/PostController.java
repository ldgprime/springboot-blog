package com.ldg.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
