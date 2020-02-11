package com.ldg.blog.repository;

import java.util.List;

import com.ldg.blog.model.comment.dto.ReqDetailDto;
import com.ldg.blog.model.comment.dto.RespDetailDto;

public interface CommentRepository {
	//public 안붙여도 된다 interface라서
	int save(ReqDetailDto dto);
	
	RespDetailDto findById(int id);
	
	int delete(int id);
	
	List<RespDetailDto> findByPostId(int postId);
	
}
