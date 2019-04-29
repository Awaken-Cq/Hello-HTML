package com.kitri.jdbcTest;

import java.sql.*;
import java.util.Date;

public class ConnectionTest {
	
	public ConnectionTest() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void dbConnect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
//			프로토콜(프로토콜에 따라 형식이 바뀜):ip:포트번호:식별자
			System.out.println("DB Connection Success!!!!");
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		 ConnectionTest ct = new ConnectionTest();
		 ct.dbConnect();
		 
		 
	}
}
