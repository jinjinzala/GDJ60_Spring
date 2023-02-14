package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/member/*")


public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin")
	public String  getMemberjoin() {
		System.out.println("MemberJoin");
		
		return"member/memberJoin";
		
	}
	
	 
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String getMemberJoin(MemberDTO memberDTO) throws Exception {
	int result = memberService.setMemberJoin(memberDTO);
	System.out.println(result==1);
	return "redirect:./list";
	}
	
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void setMemberJoin() {
	      
	 }


	
	@RequestMapping(value="memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value="mypage")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}

}
