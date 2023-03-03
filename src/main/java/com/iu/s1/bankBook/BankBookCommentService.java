package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.util.Pager;

@Service
public class BankBookCommentService implements BbsService{

	@Autowired
	private BbsDAO bankBookCommentDAO;
	//private BankBookCommentDAO bankbookCommentDAO;
	
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
	
		pager.makeNum(bankBookCommentDAO.getTotalCount(pager));
		
		return bankBookCommentDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	public ModelAndView setBankBookreply(BbsDTO bbsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
}
