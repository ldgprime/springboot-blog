package com.ldg.blog.model.comment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder
public class ReqDetailDto {
	private int id;
	private int postId;
	private int userId;
	private String content;
}
