package com.ldg.blog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.post.Post;
import com.ldg.blog.model.post.dto.RequestUpdateDto;
import com.ldg.blog.model.post.dto.RequestWriteDto;
import com.ldg.blog.model.post.dto.RespListDto;
import com.ldg.blog.model.user.User;
import com.ldg.blog.service.CommentService;
import com.ldg.blog.service.PostService;



@Controller
public class PostController {

	@Autowired
	private PostService postService ;
	
	@Autowired
	private CommentService commentService;
	
	
	

	
	
	@GetMapping({"/","","/post"})
	public String posts(Model model) {		
		
		List<RespListDto> posts = postService.목록보기();
		
		
		model.addAttribute("posts",posts);
		
		return "/post/list";
	}
	
	
	//인증 체크
	@GetMapping("/post/write")
	public String write() {
		
		return "/post/write";
	}
	
	//인증 체크, 동일인 인증 null체크 인증체크 하지 않아도 된다.
	@GetMapping("/post/update/{id}")
	public String update(@PathVariable int id, Model model, @AuthenticationPrincipal User principal) {		
		
		model.addAttribute("post", postService.수정하기(id,principal));
		
		return "/post/update";
	}
	
	
	@PutMapping("/post/update")
	public ResponseEntity<?> update(@RequestBody RequestUpdateDto dto ){
		
		int result = postService.글수정(dto);
		
		
		if(result == 1) {
		
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity<RespCM>(new RespCM(400,"ok"),HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@PostMapping("/post/write")
	public ResponseEntity<?> wirte(@RequestBody RequestWriteDto dto, @AuthenticationPrincipal User principal){
		
		int result = postService.글쓰기(dto);
	
		
		if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);  
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400,"fail"),HttpStatus.BAD_REQUEST);
		}		
		
	}
	
	@GetMapping("/post/detail/{id}")
	public String detail(@PathVariable int id, Model model) {		
		
		Post post = postService.글상세보기(id);
		model.addAttribute("comments", commentService.목록보기(id));
		model.addAttribute("post",post);
		//두개 합치면 된다!
		
		return "/post/detail";
	}
	

	
	@DeleteMapping("/post/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id, Model model, @AuthenticationPrincipal User principal) {
		
		//동일인 체그 session의 principal.id == 해당 post.userid 비교
		
		
		int result = postService.삭제하기(id,principal);
		
		
		if(result == 1) {
		
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
			
		
		}else if(result == -3) {
			
			return new ResponseEntity<RespCM>(new RespCM(409,"fail"),HttpStatus.FORBIDDEN);
			
		}else {
			
			return new ResponseEntity<RespCM>(new RespCM(400,"fail"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
