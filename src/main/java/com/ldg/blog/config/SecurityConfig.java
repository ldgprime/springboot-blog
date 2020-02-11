package com.ldg.blog.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldg.blog.model.RespCM;
import com.ldg.blog.model.user.User;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	
	//모든 주소요청을 받음
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//403에러		
		http.csrf().disable();
		
		http.authorizeRequests()		//인증이 필요하다.	
			.antMatchers("/user/profile/**", "/post/write/**", "/post/update/**", "/post/delete/**").authenticated()
			//권한이 필요하다
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
			.anyRequest().permitAll()
		.and()
			//form 로그인 방식을 사용할거다
			.formLogin()
			//인증 안되면 이리로 가라
			.loginPage("/user/login")//get방식			
			.loginProcessingUrl("/user/loginProc")//post 낚아챔
			.successHandler(new AuthenticationSuccessHandler() {				
				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					
//						User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//						
//						HttpSession session = request.getSession();
//						session.setAttribute("principal", principal);
								
						
						PrintWriter out = response.getWriter();						
						ObjectMapper mapper = new ObjectMapper();						
						
						String jsonString = mapper.writeValueAsString(new RespCM(200,"ok"));
						out.print(jsonString);
						out.flush();
				}
			});
			
//			.failureHandler(authenticationFailureHandler) 실패시			
//			.defaultSuccessUrl("/")// url 설정 시				
	}
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	//로그인할 때 비밀번호 암호화
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encode());
	}
	
}
