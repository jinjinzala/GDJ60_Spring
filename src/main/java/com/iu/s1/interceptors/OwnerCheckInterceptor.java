package com.iu.s1.interceptors;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//auto-boxing
		Long num = Long.parseLong(request.getParameter("num"));
		
		System.out.println("url: "+ request.getRequestURI());
		System.out.println("pathinfo: "+request.getPathInfo());
		System.out.println("ServletPath: "+request.getServletPath());
		
		
		//qna아니면 update가 나오게하세여
		String uri = request.getRequestURI();
		uri  = uri.substring(1,uri.lastIndexOf("/"));
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		
		if(uri.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		}else {
			boardDTO = qnaDAO.getBoardDetail(boardDTO);
		}
		
		
		MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
		
	
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			
			request.setAttribute("result", "작성자만 접근이 가능합니다");
			request.setAttribute("url","./list");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		return true;
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		//1. 로그인한 사용자의 id
//		System.out.println("멤버체크인터셉트");
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		
//		//2.boardDTO를 ModelandView
//		Map<String, Object> map = modelAndView.getModel();
//		//get("dto") 앞으로 속성명은 dto로 보내줘! 
//	    BoardDTO boardDTO =  (BoardDTO)map.get("dto");
//	    //map안에 뭐가 들어있는지 궁금할때 map.keySet().iterator()이랑 while문 활용
//	    
//	    //3.check (아이디가 같지않으면 )
//	    if(memberDTO == null || !boardDTO.getWriter().equals(memberDTO.getId())) {
//	    	//void타입이니깐 리턴값을 줄 수 없어서 modelAndView를 수정해서보내버리자
//	    	modelAndView.setViewName("common/result");
//	    	modelAndView.addObject("result", "작성자만 수정 및 삭제가 가능합니다 무단침범 금지");
//	    	modelAndView.addObject("url","./list");
//	    }
	    
	    //super.postHandle(request, response, handler, modelAndView);
//	}
}
