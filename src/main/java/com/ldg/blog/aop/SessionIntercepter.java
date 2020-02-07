package com.ldg.blog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//백종원 = 어댑터패턴
//@Controller, @Configulation, @Service, @Repository
//@Component 특별히 이름짖지 않고 싱글톤으로 만들경우
public class SessionIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//??? 세션을 사용하나????
		HttpSession session = request.getSession();
		
		if(session.getAttribute("principal")== null) {
			System.out.println("인증이 되지 않았습니다.");
			response.sendRedirect("/user/login");
			//컨트롤러의 함수가 실행되지 않고  intercepter에서  밖으로 튕겨나감
			return false;
		}		
		
		return true;
	}
	
}
