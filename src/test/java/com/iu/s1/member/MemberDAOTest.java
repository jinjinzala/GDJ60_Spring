package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{

	@Autowired
	 private MemberDAO memberDAO;
	
	@Test
	public void setAddMemberTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("kin");
		memberDTO.setEmail("kim@badmdmd.com");
		memberDTO.setMemberPhone("01030020478");
		memberDTO.setPw("ddddd");
		memberDTO.setMemberName("kimheej8in");
		int result = memberDAO.setAddMemberJoin(memberDTO);
		assertEquals(1, result);
		
	}
	
	
	

}
