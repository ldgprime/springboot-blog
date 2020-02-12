package com.ldg.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ldg.blog.model.user.User;
import com.ldg.blog.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	public User getPrincipal() {
		return user;
	}
	
	
	//token의 username을 가지고 UserDetail을 만듬
	//password는 가지고 있다가 username과 매칭을 알아서 해줌 개발자도 password 건들지 않는다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.authentication(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("해당 유저가 없습니다.");
		}
		
		return user;
	}
}
