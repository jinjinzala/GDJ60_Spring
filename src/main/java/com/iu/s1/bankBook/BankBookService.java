package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class BankBookService {

	@Autowired
	private BankBookDAO bankBookDAO = new BankBookDAO();
	
	
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception{
		pager.makeRow();
		Long totalCount = bankBookDAO.getBankBookCount(pager);
		
		pager.makeNum(totalCount);
		
		return bankBookDAO.getBankBookList(pager);
	}
	
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
		
//		Long productNum = productDAO.getProductNum();
//		productDTO.setProductNum(productNum);
//		int result = productDAO.setProductAdd(productDTO);
		
		return bankBookDAO.setBankBookAdd(bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO)throws Exception {
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
	

	
}
