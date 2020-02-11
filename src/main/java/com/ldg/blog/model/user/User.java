package com.ldg.blog.model.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class User implements UserDetails{
	private int id;
	private String username;
	private String password;
	private String email;
	private String profile;
	private Timestamp createDate;
	private String role;//USER,MANAGER,ADMIN
	
	@Builder
	public User(String username, String password, String email, String profile, String role) {
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.role = role;
		
	}
	
	//username과 password의 getter도 만들어져야 하는데
	//우리는 필드명을 username과 password로 만들었고 Lombok도 있어서
	//안만들어지는 것이다.
	
	//여러개의 권한을 리턴
	@Override										//시큐리티 hasrole이 보이면 하나씩 꺼내서 확인한다.
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		Collection<SimpleGrantedAuthority> collectors = new ArrayList<SimpleGrantedAuthority>();
												//규칙	
		collectors.add(new SimpleGrantedAuthority("ROLE_"+role));
		return collectors;
		
//		return null;
	}
	
	//계정이 만료되었는지 체그하여 리턴한다. (true: 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 잠겨있는지 체크하여 리턴한다. (true: 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호가 만료되었는지 체크하여 리턴한다. (true: 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//해당 계정이 활성화 되어있는지 체크하여 리턴한다. (true: 활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

		
}
