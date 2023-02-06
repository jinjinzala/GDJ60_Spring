package com.iu.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/member/*")


public class MemberController {

	@RequestMapping(value="memberjoin")
	public String  getMemberjoin() {
		System.out.println("MemberJoin");
		//System.out.println(ar.size()>0);
		return"member/memberJoin";
		
	}
	
	@RequestMapping(value="memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value="memberList")
	public void memberList() {
		
	}
	
	@RequestMapping(value="mypage")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}

}