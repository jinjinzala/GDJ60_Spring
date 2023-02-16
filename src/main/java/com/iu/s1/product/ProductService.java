package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class ProductService {
	//서비스는 dao에 의존적이다 
	//결합도가 높다 
	//1번 잘안써영 
	
	@Autowired
	private ProductDAO productDAO = new ProductDAO();
	
		
	public List<ProductDTO> getProductList(Pager pager) throws Exception {
		pager.makeRow();
		
		Long totalCount = productDAO.getProductCount(pager);
		
		pager.makeNum(totalCount);
		
		return  productDAO.getProductList(pager);
	}
		
	
	public int setProductAdd(ProductDTO productDTO, List<ProductOptinDTO> ar) throws Exception {
		//product, option 
		//매개변수를 호출하기위해선 객체부터 만들기 
	   Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar!=null) {
		for(ProductOptinDTO productOptinDTO:ar) {
			productOptinDTO.setProductNum(productNum);
			result =productDAO.setAddProductOption(null);
		}
		}
		//productDTO.setAddproductOption(null)
		return result;
	}
	
	public ProductDTO getProductDetail1(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
		
		
	}
	
	
	//서비스의 구성 dao
	//service
	
//	public static void main(String[] args) {
//		ProductDAO productDAO = new ProductDAO();
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductName("product1");
//		productDTO.setProductDetail("detail1");
//		
//		ProductOptinDTO productOptinDTO = new ProductOptinDTO();
//		productOptinDTO.setOptionName("optionName1");
//		productOptinDTO.setOptionPrice(100L);
//		productOptinDTO.setOptionAmount(10L);
//		productOptinDTO.setProductNum(null);
//		
//		ProductOptinDTO productOptinDTO2 = new ProductOptinDTO();
//		productOptinDTO2.setOptionName("optionName2");
//		productOptinDTO2.setOptionPrice(200L);
//		productOptinDTO2.setOptionAmount(20L);
//		productOptinDTO2.setProductNum(null);
//		
//		try {
//			Long num = productDAO.getProductNum();
//			
//			productDTO.setProductNum(num);
//			
//			int result = productDAO.setAddProduct(productDTO);
//			
//			productOptinDTO.setProductNum(num);
//			
//			if(result>0) {
//				productDAO.setAddProductOption(productOptinDTO);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
