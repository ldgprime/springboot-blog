package com.ldg.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespCM {
	private int statusCode;
	private String msg;
}
