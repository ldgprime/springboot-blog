package com.ldg.blog.repository;

import com.ldg.blog.model.user.dto.ReqJoinDto;

public interface UserRepository {
	
	int save(ReqJoinDto dto);
	
	int findByUsername(String username);

}
