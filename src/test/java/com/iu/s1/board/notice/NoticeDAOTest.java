package com.iu.s1.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.bankBook.BankBookDTO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;




public class NoticeDAOTest extends MyTestCase {

	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getBoardListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		//long count = bankBookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar=noticeDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
	}
	
	
	
	
	@Test
	public void setBoardAddTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("타이틀");
		noticeDTO.setWriter("타이틀");
		noticeDTO.setContents("타이틀");
		int result = noticeDAO.setBoardAdd(noticeDTO);
		assertNotEquals(1,result);
	}
	
	/*
	 * @Test public void setBankBookAddTest() throws Exception{
	 * 
	 * for(int i=0; i<30; i++) { Random r = new Random(); double d = r.nextDouble();
	 * int num = (int)(d*1000); d = num/100.0; BankBookDTO bankBookDTO = new
	 * BankBookDTO(); bankBookDTO.setBookDetail("BABO");
	 * bankBookDTO.setBookName("한국투자"+i); bankBookDTO.setBookNumber(13L);
	 * bankBookDTO.setBookRate(d); bankBookDTO.setBookSale(1L); int result =
	 * bankBookDAO.setBankBookAdd(bankBookDTO); assertEquals(1, result); } }
	 */
	
}
