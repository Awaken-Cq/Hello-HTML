package com.kitri.jdbcTest;

import java.sql.*;

public class InsertTest {

//	1.
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	2.
	public Connection makeConnection() throws SQLException  {
		Connection conn = null;
		

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("DB Connection Success!!");
			

		return conn;
	}
	
	
//	3.
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		
		String name = "노정탁";
		String id = "taks";

		Connection conn = null;
		Statement stmt = null;
		
		int cnt = 0;
		
		try {
			
			conn = it.makeConnection();
			
			String sql = "";
			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '" + name + "', '" + id +"', sysdate)";
			System.out.println(sql);
			
			stmt = conn.createStatement();
			
//	4.
			cnt = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

//	5.
		} finally {
			try {
				if(stmt != null) {
				stmt.close();
				}
				if(conn != null) {
					conn.close();					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(cnt != 0)
			System.out.println("Data Insert Success!!");
		else
			System.out.println("Data Insert Fail..");
		
	}

}
