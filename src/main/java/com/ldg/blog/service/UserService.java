package com.ldg.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			if(result == 1) {
				return ReturnCode.아이디중복;
			}else {				
				return userRepository.save(dto);
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
			
	}
	
	
	@Transactional
	//변수 따로 처리해도 된다. dto 만들어서 해도 된다.
	public User 로그인(ReqloginDto dto) {
		return userRepository.findByUsernameAndPassword(dto);
	}
	
	
	
	
	
	
	
	
	
//	@Transactional // rollback;
//	public int join() {
//		try {
//		    userRepository.save();	
//		    userRepository.save();	
//		    userRepository.save();	
//		    userRepository.save();	
//		    
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new RuntimeException();
//		}
//		
//		return 1;
//	}
	
	
}
