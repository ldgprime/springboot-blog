package com.ldg.blog.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldg.blog.model.Criteria;
import com.ldg.blog.model.PageMaker;
import com.ldg.blog.model.ReturnCode;
import com.ldg.blog.model.post.Post;
import com.ldg.blog.model.post.dto.RequestUpdateDto;
import com.ldg.blog.model.post.dto.RequestWriteDto;
import com.ldg.blog.model.post.dto.RespListDto;
import com.ldg.blog.model.user.User;
import com.ldg.blog.repository.PostRepository;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository postRepository;	
	
	public int 글쓰기(RequestWriteDto dto) {
		return postRepository.save(dto);
	}
	
	
	public int 글수정(RequestUpdateDto dto) {
		return postRepository.updateById(dto);
	}
	
	public Post 글상세보기(int id) {
		return postRepository.findById(id);
	}
	
	public List<RespListDto> 목록보기(Criteria criteria ){	
		
		int pagelimit = (criteria.getPage()-1);
		criteria.setPagelimit(pagelimit);
		List<RespListDto> posts = postRepository.posts(criteria);
		
		return posts;
	}
	public int 총글수(Criteria criteria) {
		
		int count = postRepository.countPaging(criteria);
		return count;
	}
	
	public int 삭제하기(int id, User principal ){
		
		Post post = postRepository.findById(id);
		
		
		if(principal.getId() == post.getUserId()) {
			return postRepository.delete(id);
		}else{
			return ReturnCode.권한없음;
		}
	}
	
	public Post 수정하기(int id, User principal) {
		
		Post post =  postRepository.findById(id);
		
	
		if(principal.getId() == post.getUserId()) {
			return post;
		}else{
			return null;
		}
		
	}
	

}
