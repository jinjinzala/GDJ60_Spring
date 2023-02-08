package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.bankBook.BankBookDAO;
import com.iu.s1.bankBook.BankBookDTO;


public class BankBookDAOTest extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		assertNotEquals(0, ar.size());	
	}
	
	@Test
	public void getBankBookDetailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	@Test
	public void setBankBookAddTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookDetail("BABO");
		bankBookDTO.setBookName("KIMHEEJIN");
		bankBookDTO.setBookNumber(13L);
		bankBookDTO.setBookRate(3.0);
		bankBookDTO.setBookSale(1L);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		assertEquals(1, result);
	}
	
	
	public void setBankBookDelete() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookDetail("BABO");
		bankBookDTO.setBookName("KIMHEEJIN");
		bankBookDTO.setBookNumber(13L);
		bankBookDTO.setBookRate(3.0);
		bankBookDTO.setBookSale(1L);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		assertEquals(1, result);
	}

}
