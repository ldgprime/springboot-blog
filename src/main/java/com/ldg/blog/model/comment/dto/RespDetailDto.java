package com.ldg.blog.model.comment.dto;

import java.sql.Timestamp;

import com.ldg.blog.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespDetailDto {
	
	private RespCM status;
	
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	private String username;
	
}
