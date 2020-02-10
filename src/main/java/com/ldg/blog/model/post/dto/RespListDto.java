package com.ldg.blog.model.post.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespListDto {
	private int id;
	private String title;
	private String content;
	private int userId;
	private String username;
	private Timestamp createDate;
}
