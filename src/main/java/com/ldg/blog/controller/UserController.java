package com.ldg.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.user.User;
import com.ldg.blog.model.user.dto.ReqJoinDto;
import com.ldg.blog.model.user.dto.ReqloginDto;
import com.ldg.blog.service.UserService;

@Controller
public class UserController {
	
	private static final String TAG ="UserController:";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/user/join")	
	public String join() {		
		return "/user/join";
	}
	
	@GetMapping("/user/login")	
	public String login() {
	
		return "/user/login";
	}
	
	@GetMapping("/user/logout")	
	public String logout() {
		
		session.invalidate();
		return "redirect:/";
		
	}
	
	//세션인증, 동일인 인증
	@GetMapping("/user/profile/{id}")	
	public String profile(@PathVariable int id) {
		
		User principal =(User) session.getAttribute("principal");		
		
		
			if(principal.getId() == id) {
				return "/user/profile";
			}else {
			
				return "/user/login";
			}
			
		
	}

	
	@PostMapping("/user/join")	
	public ResponseEntity<?> joinProc(@Valid @RequestBody ReqJoinDto dto,BindingResult bindingResult) {

		
		if(bindingResult.hasErrors()) {

			Map<String,String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}		
		
		int result = userService.회원가입(dto);
		
		if(result == 2) {
			return new ResponseEntity<RespCM>(new RespCM(-2,"아이디중복"),HttpStatus.OK);
		}else if(result == 1){
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(500,"fail"),HttpStatus.INTERNAL_SERVER_ERROR);
		}			
		
	}
	            
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@Valid @RequestBody ReqloginDto dto, BindingResult bindingResult) {
		
		//request 검증 = AOP 처리 예정
		
		//서비스 호출
	    User principal = userService.로그인(dto);  
	    
		if(principal != null) {
			//세션 인증
			session.setAttribute("principal", principal);
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400,"fail"),HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
	
}
