package com.iu.s1.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//리턴이 트루라면 다음 컨트롤러로 잔행
		// 리턴이 거짓이라면 다음컨트롤ㄹ러로 진행 x 
		
		System.out.println("컨트롤러 진입 전 체크");
		response.sendRedirect("");
		return true;
	}	
	
	
	
	
	
	
}
