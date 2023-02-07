package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DBConnection {


   public static Connection getConnection() throws Exception { 
	   String user = "user01";
	   String password = "user01";
	   String url = "jdbc:oracle:thin:@192.168.1.95:1521:xe";
	   String driver = "oracle.jdbc.driver.OracleDriver";
	   
	   //2. Driver를 메모리에 로딩
	   Class.forName(driver);
	   
	   //3. DB 연결 
	   return DriverManager.getConnection(url, user, password);	   
   }     

   //배포전에 삭제하세요 
   public static void main(String[] args) {
	  try {
		Connection con = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
   }
   
   
   public static void disConnect(PreparedStatement st,Connection connection)throws Exception {
		st.close();
		connection.close();
	}

   
   public static void disConnect(ResultSet rs,PreparedStatement st,Connection connection) throws Exception {
		  rs.close();
		  st.close();
		  connection.close();
		  }
}
