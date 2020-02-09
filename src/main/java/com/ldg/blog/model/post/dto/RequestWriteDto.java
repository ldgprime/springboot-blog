package com.ldg.blog.model.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestWriteDto {
	
	private String title;
	private String content;
	private int userId;
	
}
