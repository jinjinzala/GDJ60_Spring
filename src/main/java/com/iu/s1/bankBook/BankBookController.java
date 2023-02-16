package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBook/*")

public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//list 
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("service 전" + pager.getTotalCount());
		List<BankBookDTO> ar = bankBookService.getBankBookList(pager);
		System.out.println("service 후" + pager.getTotalCount());
		
		mv.setViewName("bankBook/list");
		mv.addObject("list",ar);
		mv.addObject("pager", pager);
		
		return mv;
	}
	
	//detail
	@RequestMapping (value = "detail" , method = RequestMethod.GET )
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.setViewName("/bankBook/detail");
		mv.addObject("dto",bankBookDTO);
		
		return mv;		
	}
	
	//add form 이동 
	
	@RequestMapping (value = "add", method = RequestMethod.GET )
	public ModelAndView setBankBookAdd(ModelAndView mv) throws Exception {
		mv.setViewName("/bankBook/add");
		return mv;
		
	}
	
	@RequestMapping (value = "add", method = RequestMethod.POST )
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic, ServletContext servletContext,HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Name: "+pic.getName());
		System.out.println("origin"+pic.getOriginalFilename());
		System.out.println("size"+pic.getSize());
		System.out.println(session.getServletContext());
		//int값은 나중에 사용할 예정~ 받아만두세여
		int result = bankBookService.setBankBookAdd(bankBookDTO,pic);
		
		//앞에 리다이렉트를 써주면 스프링이 알아서 인식해줌 
		mv.setViewName("redirect:./list");
		return mv;
	}

	//delete

	@RequestMapping (value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	//수정 폼 이동
	@RequestMapping(value = "update", method=RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
	ModelAndView mv = new ModelAndView();
	//번호를 주면 가지고 오는 디테일을 이용해라! 
	bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
	mv.setViewName("bankBook/update");
	mv.addObject("dto", bankBookDTO);
	return mv;
	}
	
	//업데이트 post 
	 @RequestMapping(value = "update",method = RequestMethod.POST)
	 public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO ,ModelAndView mv) throws Exception{
	 int result = bankBookService.setBankBookUpdate(bankBookDTO);
	 mv.setViewName("redirect:./list");
	 return mv;
	 }
	
	

	
	
	
}
