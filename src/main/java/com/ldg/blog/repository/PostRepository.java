package com.ldg.blog.repository;




import java.util.List;


import com.ldg.blog.model.Criteria;
import com.ldg.blog.model.post.Post;
import com.ldg.blog.model.post.dto.RequestUpdateDto;
import com.ldg.blog.model.post.dto.RequestWriteDto;
import com.ldg.blog.model.post.dto.RespListDto;

public interface PostRepository {	
	
	int save(RequestWriteDto dto);
	
	List<RespListDto> posts(Criteria criteria);
	
	Post findById(int id);
	
	int updateById(RequestUpdateDto dto);
	
	int delete(int id);	
	
	int countPaging(Criteria criteria);
	
	
}
