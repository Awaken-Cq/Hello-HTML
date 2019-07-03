package com.kitri.util;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBConnection {
	
//	static {
//		try {
//			Class.forName(SiteConstance.DB_DRIVER);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Connection makeConnection() throws SQLException {
//		
//		return DriverManager.getConnection(SiteConstance.DB_URL,SiteConstance.DB_USERNAME,SiteConstance.DB_PASSWORD);
//	}
	public static Connection makeConnection() throws SQLException {
		try {
			Context ictx = new InitialContext();
			Context ctx = (Context) ictx.lookup("java:comp/env");
			DataSource dataSource = (DataSource) ctx.lookup("jdbc/kitri");
			return dataSource.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
	}
}
