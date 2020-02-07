package com.ldg.blog.model.user.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqloginDto {
	
	//ajax body에 담아 보내진다
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디에 한글이 입력될 수 없습니다.")
	@Size(max = 15, message = "아이디 길이가 잘못되었습니다.")
	@NotBlank(message = "아이디를 입력하세요.")
	private String username;
	
	@Size(max = 15, message = "비밀번호 길이가 잘못되었습니다.")
	@NotBlank(message = "비밀번호를 입력하세요.")
	private String password;	

	
}
