package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.bankBook.BankBookCommentDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;


public class BankBookCommentDAOTest extends MyTestCase {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	
	//list
	@Test
	public void getBoardListTest() throws Exception {
		Pager pager = new Pager();
		pager.setKind("writer");
		pager.setBookNumber(385L);
		pager.setSearch("김희진");
		pager.makeRow();
		//long count = bankBookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar= bankBookCommentDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
	}
}
