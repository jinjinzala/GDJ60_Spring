package com.iu.s1.product;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getProductList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> ar = productService.getProductList(pager);
	  
		mv.setViewName("product/productList");
		mv.addObject("list",ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
	//getProductDetail
	@RequestMapping(value="detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception{
		//파라미터 이름과 setter의 이름과 같아야함 
		
		System.out.println("Product detail");
		
		//String num= request.getParameter("num");
		//ProductDTO productDTO = new ProductDTO();
		//productDTO.setProductNum(num);
		//productDTO.setProductName(name);
		//productDTO.setProductJumsu(age);
		
		productDTO = productService.getProductDetail1(productDTO);
		
		System.out.println(productDTO!=null);
		
		model.addAttribute("dto",productDTO);
		
		return "product/productDetail";
	}
	
	@RequestMapping(value="productAdd",method = RequestMethod.GET)
	public void setproductAdd() {
	}
	
	//productadd html에서 받아온 입력데이터 
	@RequestMapping(value="productAdd",method = RequestMethod.POST)
	public String setproductAdd(ProductDTO productDTO) throws Exception {
	  int result = 	productService.setProductAdd(productDTO, null);
		System.out.println(result == 1 );
		return "redirect:./list";
	}
	
	@RequestMapping(value="update")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
	

	


		
	
	
}
