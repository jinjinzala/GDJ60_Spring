package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
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
			// 리턴이 거짓이라면 다음컨트롤러로 진행 x 
		System.out.println("멤버체크인터셉트");
		 Object obj = request.getSession().getAttribute("member");
		 if(obj != null) {
			return true; 
		 }
		 
		 System.out.println("로그인 안한 경우");
		//1. Foward Jsp
		//		request.setAttribute("result", "권한이 없습니다");
		//		request.setAttribute("url","../member/memberLogin");
		//		RequestDispatcher view =  request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		//		view.forward(request, response);
		 
		 
		 
		//2.Redirect
		 response.sendRedirect("../../../../member/memberLogin");
		 return false;
	}	
	
	
	
	
}
