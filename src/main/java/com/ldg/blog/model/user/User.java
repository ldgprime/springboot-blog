package com.ldg.blog.model.user;

import java.sql.Timestamp;


import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String profile;
	private Timestamp createDate;
	
	@Builder
	public User(String username, String password, String email, String profile) {
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		
	}	
		
}
