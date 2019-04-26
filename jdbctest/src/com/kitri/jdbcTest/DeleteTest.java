package com.kitri.jdbcTest;

import java.sql.*;

public class DeleteTest {

	
	public DeleteTest() {
		
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
		DeleteTest dt = new DeleteTest();
		
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			String id = "taks";
			
			String sql = "";
			sql += "delete jdbctest \n";
			sql += "where id = '" + id + "'";
			
			conn = dt.makeConnection();
			stmt = conn.createStatement();
			
			cnt = stmt.executeUpdate(sql);
			
			System.out.println(cnt +"ea Data is deleted");
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
