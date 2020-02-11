package com.ldg.blog.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldg.blog.model.ReturnCode;
import com.ldg.blog.model.comment.dto.ReqDetailDto;
import com.ldg.blog.model.comment.dto.RespDetailDto;
import com.ldg.blog.model.user.User;
import com.ldg.blog.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	

	
	
	public List<RespDetailDto> 목록보기(int id) {
		
		return commentRepository.findByPostId(id);
		
	}
	
	
	public RespDetailDto 댓글쓰기(ReqDetailDto dto) {
		int result = commentRepository.save(dto);
		
		
		
		if(result == 1) {
			RespDetailDto respDetailDto = commentRepository.findById(dto.getId());
			return respDetailDto;
		}else {
			return null;
		}
		
		
		
		
	}
	
	public int 댓글삭제(int id, User principal) {
		//해당 댓글은 누가 씀??
		
		RespDetailDto comment = commentRepository.findById(id);			
		
		
		
		if(comment.getUsername().equals(principal.getUsername())) {
			return commentRepository.delete(id);		
		}else {
			return ReturnCode.권한없음;
		}		
			
		
	}
	
	
}
