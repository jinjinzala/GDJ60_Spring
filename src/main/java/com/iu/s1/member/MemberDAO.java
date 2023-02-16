package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.member.MemberDAO."; 
	
	//--------------------------------------
	
//	public List<MemberDTO> getMemberList()throws Exception{
//		return sqlSession.selectList(NAMESPACE+"getMemberList");
//	}
	
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
		
	}
	public int setMemberRoleAdd(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberRoleAdd", memberDTO);
	}

	 
	 public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception{
			return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
		}

}
