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
	 return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
	
	//getMax
	public Long getProductNum()throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getProductNum");

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
				+ "VALUES (PRODUCTNUM_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
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
	
	public int setProductAdd(ProductDTO productDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductAdd",productDTO);
	}
	
}
