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
	

//public int setAddMemberJoin(MemberDTO memberDTO, List<MemberDTO> ar) throws Exception {
//    // Long productNum = DAO.getProductNum();
//	//memberDTO.setProductNum(productNum);
//	int result = memberDAO.setAddMemberJoin(memberDTO);
//	
//	if(ar!=null) {
//	for(MemberDTO memberDTO : ar) {
//		memberDTO.setAddMemberJoin(productNum);
//		result =memberDAO.setAddMemberJoin(null);
//	}
//	}
//	return result;
//}

//public MemberDTO getProductDetail1(MemberDTO memberDTO) throws Exception {
//	return memberDAO.getProductDetail(memberDTO);
//	
//	
//}
	
}
