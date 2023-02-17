package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class BankBookService {

	@Autowired
	private BankBookDAO bankBookDAO = new BankBookDAO();
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception{
		pager.makeRow();
		Long totalCount = bankBookDAO.getBankBookCount(pager);
		
		pager.makeNum(totalCount);
		
		return bankBookDAO.getBankBookList(pager);
	}
	
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic) throws Exception {
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		//파일 사진이 없을경우 이미지 네임을 저장하지마!
		if(!pic.isEmpty()) { 
			//pic.getSize()!=0 
			//1. file을 hdd에 저장 
			// 프로젝트 경로가아닌 os가 이용하는 경로
			
			String realPath = servletContext.getRealPath("resources/upload/bankBook/");
			System.out.println(realPath);
			String fileName = fileManager.fileSave(pic, realPath);
			
			//2. db에 저장
			BankBookImgDTO bankBookimgDTO = new BankBookImgDTO();
			bankBookimgDTO.setFileName(fileName); 
			bankBookimgDTO.setOriName(pic.getOriginalFilename());
			bankBookimgDTO.setBookNumber(bankBookDTO.getBookNumber());
			
			//3. 
			//Long productNum = productDAO.getProductNum();
			//productDTO.setProductNum(productNum);
			//int result = productDAO.setProductAdd(productDTO);
			result = bankBookDAO.setBankBookImgAdd(bankBookimgDTO);	
			
		}
		
		return result; //bankBookDAO.setBankBookAdd(bankBookDTO);
		//bankBookDTO.getBookNumber();
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO)throws Exception {
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
	

	
}
