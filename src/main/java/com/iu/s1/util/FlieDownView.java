package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Renderer;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s1.board.BoardFileDTO;


@Component("FileDownView")
public class FlieDownView extends AbstractView{
	//추상클래스는 추상메서드 하나 이상을 
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("fileDownView");	
	//타입이 Object이기 때문에 (BoardFileDTO)로 형변환을 해줘야한다.
	BoardFileDTO boardFileDTO = (BoardFileDTO)model.get("boardFile");
	//System.out.println(boardFileDTO.getFileNum());
	//System.out.println(boardFileDTO.getFileName());
	
//	Iterator<String> it = model.keySet().iterator();
//	
//	while(it.hasNext()) {
//		String key = it.next();
//		System.out.println("key"+key);
//	}
//
	//key : boardName ,boardFile 
	
	String path = (String)model.get("boardName");
	path = "resources/upload/"+path+"/";
	
	path = request.getSession().getServletContext().getRealPath(path);
	
	File file = new File(path, boardFileDTO.getFileName());
	
	//응답시 한글을 인코딩해야한다 
	response.setCharacterEncoding("UTF-8");
	
	//응답시 파일의 크기를 헤더에 담아서 보내줌
	response.setContentLength((int)file.length());
	
	//다운시 파일의 이름을 지정하고 인코딩 지정
	String downName = boardFileDTO.getOriName();
	downName = URLEncoder.encode(downName ,"UTF-8");
	
	//Header 정보 설정 문자열 쌍따옴표 \""
	response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
	response.setHeader("Content-Transfer-Encoding","binary");
	
	//전송 input(읽어오기) output  Stream(빨대만 꽃고 읽는건 아냥)
	FileInputStream fi = new FileInputStream(file);
	OutputStream os = response.getOutputStream();
	
	FileCopyUtils.copy(fi, os);
	
	//자원해제순서 역순
	
	os.close();
	fi.close();
	
	
	
	
	}
	
	
	
	
	
}
