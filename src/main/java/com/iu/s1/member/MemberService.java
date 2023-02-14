package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemberService {
   @Autowired
   private MemberDAO memberDAO;
   
   public int setMemberJoin(MemberDTO memberDTO) throws Exception {
      int result = memberDAO.setMemberJoin(memberDTO);
      result = memberDAO.setMemberRoleAdd(memberDTO);
      return result;
   }
   
   public List<MemberDTO> getMemberList() throws Exception{
      return memberDAO.getMemberList();
   }
   
   public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
	   return memberDAO.getMemberLogin(memberDTO);
   }
  
   
   
}