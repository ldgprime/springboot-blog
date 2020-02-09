package com.ldg.blog.repository;




import java.util.List;

import com.ldg.blog.model.post.Post;
import com.ldg.blog.model.post.dto.RequestUpdateDto;
import com.ldg.blog.model.post.dto.RequestWriteDto;

public interface PostRepository {
	
	
	
	
	int save(RequestWriteDto dto);
	
	List<Post> posts();
	
	Post findById(int id);
	
	int updateById(RequestUpdateDto dto);
	
	
}
