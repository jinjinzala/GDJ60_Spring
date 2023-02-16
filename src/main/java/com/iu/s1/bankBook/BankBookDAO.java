package com.iu.s1.bankBook;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.bankBook.BankBookDAO.";

	
	public Long getBankBookCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBankBookCount");
	}
	
	public Long getBookNumber() throws  Exception{
		return sqlSession.selectOne(NAMESPACE+"getBookNumber");
	}

	//id는 메서드명과 동일하게 넣기 
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getBankBookList",pager);
	} 
	
	//1개는 selectOne으로 받기 검색하려면 변수가 필요하니깐 뒤에 추가로 매개변수 dto 선언 
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getBankBookDetail", bankBookDTO);
	}
	
    //insert는 int 타입으로 
	public int setBankBookAdd(BankBookDTO bankBookDTO) throws Exception{
	
		return sqlSession.insert(NAMESPACE+"setBankBookAdd",bankBookDTO);
		
	}
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"setBankBookUpdate",bankBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setBankBookDelete",bankBookDTO);
	}
	
	public int setBankBookImgAdd(BankBookImgDTO bankBookimgDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+ "setBankBookImgAdd");
	}
	
}
