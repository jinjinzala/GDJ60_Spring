package com.iu.s1.product;

import com.iu.s1.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.iu.s1.util.DBConnection;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	
	//DELETE 
	public int setProductDelete(Long productNum) throws Exception {
	 int result= 0;
	 
	 // 1. db 연결
	 Connection con = DBConnection.getConnection();
	 // 2. sql 생성 
	 String sql = "DELETE PRODUCT WHERE PRODUCTNUM = ?"; 
	 // 3. 미리 보내기 
	 PreparedStatement st = con.prepareStatement(sql);
	 // 4. ?를 세팅하는 단계
	 st.setLong(1, productNum);
	 // 5. 최종 전송 및 결과 처리 
	 result = st.executeUpdate();
	 // 6. 연결 해제 
	 DBConnection.disConnect(st, con);
	
	 return result;
	}
	
	
	//getMax
	public Long getProductNum()throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disConnect(rs, st, con);
		
		return num;
	}
	
	//getProductDetail
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {		

		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
	}
	
	
	//--------------------------------------
	public List<ProductOptinDTO> getProductOptionList()throws Exception{
		List<ProductOptinDTO> ar = new ArrayList<ProductOptinDTO>();
	
		
		return ar;
	}
	
	public int setAddProductOption(ProductOptinDTO productOptinDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql="INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONAMOUNT) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productOptinDTO.getProductNum());
		st.setString(2, productOptinDTO.getOptionName());
		st.setLong(3, productOptinDTO.getOptionPrice());
		st.setLong(4, productOptinDTO.getOptionAmount());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	
	
	//--------------------------------------
	
	public List<ProductDTO> getProductList()throws Exception{

		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	public int setAddProduct(ProductDTO productDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddProduct",productDTO);
	}
	
}
