package com.ldg.blog.model.post;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor 

public class Post {
	private int id;
	private String title;
	private String content;
	private int userId;
	private Timestamp createDate;
	
	@Builder
	public Post(String title, String content, int userId) {
	
		this.title = title;
		this.content = content;
		this.userId = userId;
	
	}
	
	
	
}
