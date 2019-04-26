package com.kitri.jdbcTest;

import java.io.ObjectInputStream.GetField;
import java.sql.*;

import oracle.jdbc.driver.DBConversion;

//taks의 가입일을 현재시간으로 수정.
public class UpdateTest {
	
	public UpdateTest() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("DB Connection Success!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
//		ut.makeConnection();
		
		Connection conn = null;
		Statement stmt = null;
		String id = "taks";
		
		try {
			String sql = "";
			sql += "update jdbctest \n";
			sql += "set joindate = sysdate \n";
			sql += "where id = '" + id + "'";
			
			conn = ut.makeConnection();
			stmt = conn.createStatement();
			
			int cnt = stmt.executeUpdate(sql);
			
			

				System.out.println(cnt + "ea Data is updated!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(stmt != null)
						stmt.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}

	
}	
	