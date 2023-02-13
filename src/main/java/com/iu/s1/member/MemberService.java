package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
@Autowired
private MemberDAO memberDAO = new MemberDAO();
	
	
public List<MemberDTO> getMemberList() throws Exception {
	return  memberDAO.getMemberList();
}

public int setAddMemberJoin(MemberDTO memberDTO)throws Exception{
	 return memberDAO.setAddMemberJoin(memberDTO);
}

	
}
