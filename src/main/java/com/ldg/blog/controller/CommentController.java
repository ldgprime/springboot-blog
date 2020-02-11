package com.ldg.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.comment.dto.ReqDetailDto;
import com.ldg.blog.model.comment.dto.RespDetailDto;
import com.ldg.blog.service.CommentService;




//@Controller + @ResponseBody 스프링 4.0
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/comment/write")
	public ResponseEntity<?> write(@RequestBody ReqDetailDto dto) {
		
		RespDetailDto respDetailDto =  commentService.댓글쓰기(dto);
		if(respDetailDto != null) {
			respDetailDto.setStatus(new RespCM(200,"ok"));
			return new ResponseEntity<RespDetailDto>(respDetailDto,HttpStatus.OK);
		}else {
			RespDetailDto error = new RespDetailDto();
			error.setStatus(new RespCM(400,"fail"));
			return new ResponseEntity<RespDetailDto>(error,HttpStatus.BAD_REQUEST);
		}			
	}
	
	@DeleteMapping("/comment/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
	
		int result = commentService.댓글삭제(id);
		

		//해당 댓글은 누가 씀??	
		
		//지금 로그인 주체는 누구인가?
		
		
		if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		}else if (result ==3) {
		    return new ResponseEntity<RespCM>(new RespCM(403,"fail"),HttpStatus.FORBIDDEN);	
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400,"ok"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
		
}
	
	
	
	
	
	
	
	
