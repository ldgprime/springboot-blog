package com.ldg.blog.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.post.Post;
import com.ldg.blog.model.post.dto.RequestUpdateDto;
import com.ldg.blog.model.post.dto.RequestWriteDto;
import com.ldg.blog.model.user.User;
import com.ldg.blog.repository.PostRepository;



@Controller
public class PostController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private PostRepository postRepository;
	
	
	@GetMapping({"/","","/post"})
	public String posts(Model model) {
		
		List<Post> posts = postRepository.posts();
		
		model.addAttribute("posts",posts);
		
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
	@GetMapping("/post/update/{postId}/{userId}")
	public String update(@PathVariable int postId, @PathVariable int userId, Model model) {
		
		
		User principal = (User) session.getAttribute("principal");
		
		if(principal.getId() != userId) {
			
			return "/user/login";
		}
		
		
		Post post = postRepository.findById(postId);
		
		model.addAttribute("post",post);
		
		return "/post/update";
	}
	
	@PostMapping("/post/write")
	public ResponseEntity<?> wirte(@RequestBody RequestWriteDto dto){

		int result = postRepository.save(dto);
	
		
		if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);  
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400,"fail"),HttpStatus.BAD_REQUEST);
		}		
		
	}
	
	@GetMapping("/post/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		
		
		Post post = postRepository.findById(id);
		
		model.addAttribute("post",post);
		
		return "/post/detail";
	}
	
	@PutMapping("/post/update")
	public ResponseEntity<?> update(@RequestBody RequestUpdateDto dto ){
		
		int result = postRepository.updateById(dto);
		
		
		if(result == 1) {
		
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<RespCM>(new RespCM(400,"ok"),HttpStatus.BAD_REQUEST);
		}
			
	}
	
	
}
