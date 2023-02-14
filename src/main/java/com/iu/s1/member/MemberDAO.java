package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.product.ProductDTO;
import com.iu.s1.product.ProductOptinDTO;
import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.member.MemberDAO."; 
	
	//--------------------------------------
	
	public List<MemberDTO> getMemberList()throws Exception{

		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}
	
	public int setAddMemberJoin(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddMemberJoin",memberDTO);
	}
	
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE +"setMemberRoleAdd",memberDTO);
	}

//	 public int setMemberJoin(MemberDTO memberDTO) throws Exception {
//	      
//	      return sqlSession.insert(NAMESPACE+"setMemberJoin",memberDTO);
//	   }

}
