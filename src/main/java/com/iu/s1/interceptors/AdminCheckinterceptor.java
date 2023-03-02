package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;

@Component
public class AdminCheckinterceptor extends HandlerInterceptorAdapter{
	
	//Roll이 admin이면 통과
	//아니라면 home.jsp로 보내버리기
	//노티스의 리스트랑 디테일은 제외하고 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception {
	// 리턴이 트루라면 다음 컨트롤러로 잔행
	// 리턴이 거짓이라면 다음컨트롤러로 진행 x 
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		 
		if(memberDTO != null) {
			if(memberDTO.getRoleDTO().getRoleName().equals("ADMIN")){
				return true;
			}
		}
		 
		
		//로그인 x adminl 아닌경우 
		
		request.setAttribute("result", "권한이업서요");
		request.setAttribute("url","../../../../../");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		return false;
	}
	
	
	
	
}
