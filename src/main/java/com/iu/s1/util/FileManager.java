package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//파일을 hdd에 저장하는 역할을 하는 애
	
	public String fileSave(MultipartFile multipartFile ,String path) throws Exception {
		//  1. 어디에 저장할 것인가
		//  /resources/upload/bankBook/...
		//  2. 저장하는 관리는 운영체제가 담당
		File file = new File(path);
		
		
		// 폴더가 존재하지 않으면 폴더 생성 
		if(!file.exists()) {
		 file.mkdirs();	
		}
		
		//3.파일을 저장하기 
		//중복되지 않는 파일명 생성
		 
		//Calendar ca = Calendar.getInstance();
		//ca.getTimeInMillis();
		
		String name = UUID.randomUUID().toString();
		//4. 확장자추가 
		//오리지널 네임에서 서브스트링을 이용해서 확장자를 잘라오는 방법
		// 그냥 오리지널 네임을 붙여오는 방법
		name = name+"_"+multipartFile.getOriginalFilename();
		System.out.println(name);
		
		//5.파일저장 
		file = new File(file, name);
		
		//1. multiPartFile객체의 transferTo메서드 사용
		//multipartFile.transferTo(file);
		
		//2. Spring API FileCopyUtlis 객체의 copy 메서드 사용
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		return name;
	
	}
}
