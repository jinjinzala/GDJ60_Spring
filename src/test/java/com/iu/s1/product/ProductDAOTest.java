package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;


public class ProductDAOTest extends MyTestCase{

	 @Autowired
	   private ProductDAO productDAO;

	   @Test
	   public void getProductListTest()throws Exception {
	      List<ProductDTO> ar = productDAO.getProductList()   ;
	      //단정문
	      assertNotEquals(0, ar.size()); //ar의 사이즈가 0이 아니길 희망한다.
	      
	   }
	   
	   @Test
	   public void getProductDetailTest()throws Exception{
	      ProductDTO productDTO = new ProductDTO();
	      productDTO.setProductNum(1L);
	      productDTO = productDAO.getProductDetail(productDTO);
	      assertNotNull(productDTO);
	   }
	   
	   @Test
	   public void setProductAddTest() throws Exception{
		   ProductDTO productDTO = new ProductDTO();
		   productDAO.setAddProductOption(null);
		   productDTO.setProductNum(2L);
		   productDTO.setProductName("test");
		   productDTO.setProductDetail("testDetail");
		   int result = productDAO.setProductAdd(productDTO);
		   assertEquals(1, result);
		
		 
	   }
	   
	   


}
