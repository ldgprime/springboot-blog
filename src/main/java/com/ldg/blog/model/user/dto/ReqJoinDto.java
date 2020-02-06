package com.ldg.blog.model.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqJoinDto {
	
	//ajax body에 담아 보내진다
	@Size(min = 7, max = 15, message = "아이디 길이가 잘못되었습니다.")
	@NotBlank(message = "아이디를 입력하세요.")
	private String username;
	
	@Size(min = 7, max = 15, message = "비밀번호 길이가 잘못되었습니다.")
	@NotBlank(message = "비밀번호를 입력하세요.")
	private String password;
	
	@Size(min = 5, max = 30, message = "이메일 길이가 잘못되었습니다.")
	@Email(message = "이메일 양식이 틀렸습니다.")
	@NotBlank(message = "이메일를 입력하세요.")	
	private String email;
	
}
