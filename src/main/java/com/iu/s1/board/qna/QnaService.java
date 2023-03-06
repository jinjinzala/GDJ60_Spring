package com.iu.s1.board.qna;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.bankBook.BankBookCommentDTO;
import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	 private FileManager fileManager;
	 
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		return qnaDAO.getBoardList(pager);
	}
	
	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles , HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		System.out.println(5);
		System.out.println(multipartFiles.length);
		
		for(MultipartFile multipartFile : multipartFiles) {
			if(multipartFile.isEmpty()) {
				//다시위로 올라가세용 컨티뉴...!
				continue;
			}
			
		String fileName = fileManager.fileSave(multipartFile, realPath);
		// db에 insert 
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setNum(bbsDTO.getNum());
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(multipartFile.getOriginalFilename());
		
		result = qnaDAO.setBoardFileAdd(boardFileDTO);
		}
		//file을 hdd에 저장
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		int result =  qnaDAO.setBoardDelete(bbsDTO);
		
		if(result>0) {
			
			String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
			
			for(BoardFileDTO boardFileDTO : ar) {
			boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
		}
		
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	
	//reply insert 
	public int setReplyAdd(QnaDTO qnaDTO)throws Exception{
		//QnaDTO
		//NUM 부모의 글번호 
		//WRITER,TITLE,CONTENTS 답글로 입력한 값
		//REF : NULL 
		//STEP NULL
		//DEPTH NULL
		//1.부모의 정보를 조회
		QnaDTO parent= (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		//ref: 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
		
		//부모의 step+1
		qnaDTO.setStep(parent.getRef()+1);
		
		
		//부모의 depth : 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. step을 update 
		int result = qnaDAO.setStepUpdate(parent);
		
		//3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		return result;
		
		
	}
@Override
public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
	// TODO Auto-generated method stub
	return qnaDAO.getBoardFileDetail(boardFileDTO);
}

	

}
