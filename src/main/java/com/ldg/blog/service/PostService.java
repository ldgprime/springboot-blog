package com.ldg.blog.service;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Autowired
	private HttpSession session;
	
	
	public int 글쓰기(RequestWriteDto dto) {
		return postRepository.save(dto);
	}
	
	
	public int 글수정(RequestUpdateDto dto) {
		return postRepository.updateById(dto);
	}
	
	public Post 글상세보기(int id) {
		return postRepository.findById(id);
	}
	
	public List<RespListDto> 목록보기(){
		return postRepository.posts();
	}
	
	public int 삭제하기(int id){
		User principal = (User) session.getAttribute("principal");
		Post post = postRepository.findById(id);
		
		
		if(principal.getId() == post.getUserId()) {
			return postRepository.delete(id);
		}else{
			return ReturnCode.권한없음;
		}
	}
	

	
	public Post 수정하기(int id) {
		User principal = (User) session.getAttribute("principal");
		Post post =  postRepository.findById(id);
		
	
		if(principal.getId() == post.getUserId()) {
			return post;
		}else{
			return null;
		}
	}
	

}
