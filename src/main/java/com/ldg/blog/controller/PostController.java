package com.ldg.blog.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ldg.blog.model.user.User;


@Controller
public class PostController {
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping({"/","","/post"})
	public String posts() {
		return "/post/list";
	}
	
	@GetMapping("/post/delete/{id}")
	public String post() {
		return "/post/detail";
	}
	
	//인증 체크
	@GetMapping("/post/write")
	public String write() {
		
		return "/post/write";
	}
	
	//인증 체크, 동일인 인증 null체크 인증체크 하지 않아도 된다.
	@GetMapping("/post/update/{id}")
	public String update(@PathVariable int id) {
		
		User principal = (User) session.getAttribute("principal");
		if(principal.getId()== id) {
			
		}
		
		return "/post/update";
	}
	
	
}
