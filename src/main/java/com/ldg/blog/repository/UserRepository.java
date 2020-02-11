package com.ldg.blog.repository;

import com.ldg.blog.model.user.User;
import com.ldg.blog.model.user.dto.ReqJoinDto;
import com.ldg.blog.model.user.dto.ReqloginDto;

public interface UserRepository {
	
	int save(ReqJoinDto dto);
	
	int findByUsername(String username);
	
	User authentication(String username);
	     
	User findByUsernameAndPassword(ReqloginDto dto);
	
	int update(int id, String password, String profile);
	
	User findById(int id);
}
