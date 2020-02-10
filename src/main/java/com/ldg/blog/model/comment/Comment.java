package com.ldg.blog.model.comment;

import java.sql.Timestamp;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




//내가 수정할 수 없음 변경되지 않는 데이터
@Data
@NoArgsConstructor
public class Comment {
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	
	@Builder
	public Comment(int userId, int postId, String content) {

		this.userId = userId;
		this.postId = postId;
		this.content = content;
		
	}	
	
	
	
	
}

