package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.bankBook.BankBookDAO;
import com.iu.s1.bankBook.BankBookDTO;


public class BankBookDAOTest extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO;
	
//	@Test
//	public void getBankBookListTest() throws Exception {
//		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
//		assertNotEquals(0, ar.size());	
//	}
//	
	@Test
	public void getBankBookDetailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	@Test
	public void setBankBookAddTest() throws Exception{
		
		for(int i=0; i<30; i++) {
		Random r = new Random();
		double d = r.nextDouble();
		int num = (int)(d*1000);
		d = num/100.0;
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookDetail("BABO");
		bankBookDTO.setBookName("한국투자"+i);
		bankBookDTO.setBookNumber(13L);
		bankBookDTO.setBookRate(d);
		bankBookDTO.setBookSale(1L);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		assertEquals(1, result);
		}
	}
	
	@Test
	public void setBankBookDelete() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookDetail("BABO");
		bankBookDTO.setBookName("KIMEEJIN");
		bankBookDTO.setBookNumber(13L);
		bankBookDTO.setBookRate(3.0);
		bankBookDTO.setBookSale(0L);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setBankBookUpdateTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookDetail("BABO");
		bankBookDTO.setBookName("KIMEEJIN");
		bankBookDTO.setBookNumber(46L);
		bankBookDTO.setBookRate(3.0);
		bankBookDTO.setBookSale(0L);
		int result = bankBookDAO.setBankBookUpdate(bankBookDTO);
		assertEquals(1, result);
		
		
	}

}
