package com.ldg.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldg.blog.model.ReturnCode;
import com.ldg.blog.model.comment.dto.ReqDetailDto;
import com.ldg.blog.model.comment.dto.RespDetailDto;
import com.ldg.blog.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	public RespDetailDto 댓글쓰기(ReqDetailDto dto) {
		int result = commentRepository.save(dto);
		
		System.out.println(dto.getId());
		
		if(result == 1) {
			RespDetailDto respDetailDto = commentRepository.findById(dto.getId());
			return respDetailDto;
		}else {
			return null;
		}
		
		
		
		
	}
	
	public int 댓글삭제(int id) {
		return commentRepository.delete(id);			
		
	}
	
	
}
