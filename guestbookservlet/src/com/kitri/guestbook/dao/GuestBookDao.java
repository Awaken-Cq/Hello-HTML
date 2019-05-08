package com.kitri.guestbook.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kitri.guestbook.dto.GuestBookDto;

public class GuestBookDao {
	private static Properties DB = null;
	
	//생성자
	//DB Driver, properties Loading
	public GuestBookDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Load 성공!!");
			DB = propertiesLoad();

    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//DB 접속 정보 Load
	private Properties propertiesLoad() {
		Properties properties = new Properties();
    	
    	try {
			properties.load(new FileReader(new File(this.getClass().getResource("\\user.properties").toURI())));
			System.out.println("Properties Load 성공!!");
    		return properties;
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//DB Connection생성
	public Connection makeConnection() throws SQLException {
    	Connection con = null;
    	
    	if(DB == null) {
    		return null;
    	}
    	
    	con = DriverManager.getConnection(DB.getProperty("url"), DB);
    	System.out.println("DB Connection 성공!!");
    	
    	return con;
    }
	
	//DB Close
	private void closeDB(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//데이터 insert
	public int insert(GuestBookDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into guestbook(	\n");
		sql.append("	seq							\n");
		sql.append("	, name						\n");
		sql.append("	, subject						\n");
		sql.append("	, content					\n");
		sql.append("	, logtime					\n");
		sql.append(") values(						\n");
		sql.append("	guestbook_seq.nextval	\n");
		sql.append("	, ?								\n");
		sql.append("	, ?								\n");
		sql.append("	, ?								\n");
		sql.append("	, sysdate					\n");
		sql.append(")									\n");
		
		try {
			con = makeConnection();
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getSubject());
			pstmt.setString(++index, dto.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(con, pstmt, null);
		}
		
		return result;
	}
	
	//데이터 select
	public List<GuestBookDto> selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		StringBuffer sql = new StringBuffer();
		sql.append("select				\n");
		sql.append("    seq				\n");
		sql.append("    , name			\n");
		sql.append("    , subject		\n");
		sql.append("    , content		\n");
		sql.append("    , to_char(logtime, 'yyyy.mm.dd') as logtime	\n");
		sql.append("from guestbook	\n");
		sql.append("order by seq	desc\n");
		
		try {
			con = makeConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestBookDto dto = new GuestBookDto();
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setLogtime(rs.getString("logtime"));
				list.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(con, pstmt, rs);
		}
		
		return list;
	}
}