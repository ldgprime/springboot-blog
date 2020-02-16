package com.ldg.blog.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.user.User;
import com.ldg.blog.model.user.dto.ReqJoinDto;
import com.ldg.blog.service.UserService;

@Controller
public class UserController {
	
	
	@Value("${file.path}")
	private String fileRealPath; //서버에 배포하면 경로 변경해야함
		
	@Autowired
	private UserService userService;	
	
	@GetMapping("/user/join")	
	public String join() {		
		return "/user/join";
	}
	
	@GetMapping("/user/login")	
	public String login() {
	
		return "/user/login";
	}	

	
	//세션인증, 동일인 인증
	@GetMapping("/user/profile/{id}")	
	public String profile(@PathVariable int id, @AuthenticationPrincipal User principal) {		
				
			if(principal.getId() == id) {
				return "/user/profile";
			}else {			
				return "/user/login";
			}
				
	}
	
	//form:form 사용함!!
	//세션인증, 동일인 인증
	//@RequestParam MultipartFile[] profile 배열 가능
	@PutMapping("/user/profile")	
	public @ResponseBody String profile(@Valid @RequestParam int id, @RequestParam String password, @RequestParam MultipartFile profile,  @AuthenticationPrincipal User principal) {
				
		UUID uuid = UUID.randomUUID();		
		String uuidFilename = uuid+"_"+profile.getOriginalFilename();
		
		//java nio 객체
		Path filePath = Paths.get(fileRealPath+uuidFilename);		
		
		try {
			Files.write(filePath, profile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		                          //세션 동기화 수정완료에서 실시
		int result = userService.수정완료(id, password, uuidFilename);
		
		StringBuffer sb = new StringBuffer();
				
		if(result == 1) {			
			sb.append("<script>");
			sb.append("alert('수정완료! 다시 로그인해주세요!');");
			sb.append("location.href='/logout';");
			sb.append("</script>");
			return sb.toString();	
		}else {			
			sb.append("<script>");
			sb.append("alert('수정실패!');");
			sb.append("history.back();");
			sb.append("</script>");
			return sb.toString();	
		}		
		
	}

	
	@PostMapping("/user/join")			//bindingResult를 쓰려면 valid 같이 valid가 가진 에러메세지 bindingResult가 된다 bindingAdvice 로 보내면 된다.	
	public ResponseEntity<?> joinProc(@Valid @RequestBody ReqJoinDto dto, BindingResult bindingResult) {
			
		int result = userService.회원가입(dto);
		
		if(result == 2) {
			return new ResponseEntity<RespCM>(new RespCM(-2,"아이디중복"),HttpStatus.OK);
		}else if(result == 1){
			return new ResponseEntity<RespCM>(new RespCM(200,"ok"),HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(500,"fail"),HttpStatus.INTERNAL_SERVER_ERROR);
		}			
		
	}

	
	
}
