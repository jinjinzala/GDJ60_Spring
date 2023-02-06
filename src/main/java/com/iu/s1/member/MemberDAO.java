package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.s1.member.util.DBConnection;

public class MemberDAO {

	public int setAddProduct(ProductDTO productDTO)throws Exception{
		Connection con = DBConnection.getConnection();

		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL) "
				+ "VALUES (?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		
		int result = st.executeUpdate();
		DBConnection.disConnect(st, con);
		return result;	
	}
	
	
	public void setAddMemberJoin(MemberDTO memberDTO)throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER(ID,PW,NAME,ADDRESS,PHONENUMBER,EMAIL) "
				+ "VALUES(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
	
		
		
	}
	
	
}