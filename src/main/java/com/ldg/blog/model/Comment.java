package com.ldg.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	
	@Builder
	public Comment(int userId, int postId, String content, Timestamp createDate) {

		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.createDate = createDate;
	}	
	
	
	
	
}

