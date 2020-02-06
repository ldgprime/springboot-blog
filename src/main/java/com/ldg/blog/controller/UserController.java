package com.ldg.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.user.dto.ReqJoinDto;
import com.ldg.blog.service.UserService;

@Controller
public class UserController {
	
	private static final String TAG ="UserController:";
	
	@Autowired
	private UserService userSerice;
	
	
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
	
	//메세지 컨버터(Jackson Mapper)는 request 받을 때 setter로 호출한다.
	//ReqJoinDto: getUsername()호출됨
	@PostMapping("/user/join")	
	public ResponseEntity<?> joinProc(@Valid @RequestBody ReqJoinDto dto,BindingResult bindingResult) {
		//한글 뱉어내기
		
//		System.out.println(TAG + dto.getUsername());
//		System.out.println(TAG + dto.getPassword());
//		System.out.println(TAG + dto.getEmail());
		
		if(bindingResult.hasErrors()) {
//			return new ResponseEntity<FieldError>(bindResult.getFieldError(),HttpStatus.CREATED);
			Map<String,String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}		
		
		int result = userSerice.회원가입(dto);
		
		if(result == 2) {
			return new ResponseEntity<RespCM>(new RespCM(-2,"아이디중복"),HttpStatus.OK);
		}else if(result == 1){
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(500,"fail"),HttpStatus.INTERNAL_SERVER_ERROR);
		}			
		
	}
	
}
