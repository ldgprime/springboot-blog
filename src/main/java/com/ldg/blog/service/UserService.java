package com.ldg.blog.service;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldg.blog.model.ReturnCode;
import com.ldg.blog.model.user.User;
import com.ldg.blog.model.user.dto.ReqJoinDto;
import com.ldg.blog.model.user.dto.ReqloginDto;
import com.ldg.blog.repository.UserRepository;

@Service
//DML에서만
public class UserService {	

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;  
	
	
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			if(result == 1) {
				return ReturnCode.아이디중복;
			}else {				
				String encodePassword = passwordEncoder.encode(dto.getPassword());
				//로그인할 때도 알아서 token이 바꿔서 해준다.
				dto.setPassword(encodePassword);
				return userRepository.save(dto);
			}
			
		} catch (Exception e) {
			//try catch 안하면 하나 실수하면 터짐 throw를 해야 롤백된다. 오류메세지를 확인하려면 log  
			e.printStackTrace();
			throw new RuntimeException();
		}
			
	}
	
	
	@Transactional
	//변수 따로 처리해도 된다. dto 만들어서 해도 된다.
	public User 로그인(ReqloginDto dto) {
		return userRepository.findByUsernameAndPassword(dto);
	}
	
	                                                  //uuidfilename를 받는다.
	public int 수정완료 (int id, String password, String profile, User principal) {
		
		String encodePassword = passwordEncoder.encode(password);
		
		int result =  userRepository.update(id,encodePassword,profile);
		
		if(result == 1) {//수정 성공
			
			User user = userRepository.findById(id);
			principal.setPassword(user.getPassword());
			principal.setProfile(user.getProfile());
			
			return 1;
		}else {//수정 실패
			return -1;
		}
		
	}
	
	
}
