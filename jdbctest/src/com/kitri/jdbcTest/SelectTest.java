package com.kitri.jdbcTest;


import java.sql.*;
import java.util.*;

public class SelectTest {

	
	public SelectTest() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection makeConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("DB connection success!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	
	public List<MemberDto> memberList(String searchName) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			String sql = "";
			sql += "select no, name, id, joindate \n";
			sql += "from jdbctest \n";
			if(searchName != null)
				sql += "where name = '"+ searchName + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			MemberDto memberDto = new MemberDto();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
//				memberDto.setNo(rs.getInt(1));
//				일반적으로 컬럼의 이름을 쓰는게 맞다.알리아스가 있다면 알리아스로 씀.
				memberDto.setNo(rs.getInt("no"));
				memberDto.setName(rs.getString("name"));
				memberDto.setId(rs.getString("id"));
				memberDto.setJoindate(rs.getString("joindate"));
				
				list.add(memberDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return list;
	}
	
//	public void zero(int date) {
//		if(date < 10) {
//			"0"+date
//		}
//	}
	
	public MemberDto memberSearch(int no) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
//		Calendar cal = new gra.getInstance();
		
//	
//		String date2 = date1.getYear() + "." + (date1.getMonth()-1) + "." 
//		+ date1.getDate() 
		
		
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			String sql = "";
			sql += "select no, id, name, ";
			sql += "decode(to_char(joindate, 'yymmdd'), to_char(sysdate, 'yymmdd'), to_char(joindate, 'hh24:mi:ss'), to_char(sysdate, 'yymmdd') ";
			sql += ", to_char(joindate, 'yyddmm')) \n";
			sql += "from jdbctest \n";
			sql += "where no = " + no ;
			
			rs = stmt.executeQuery(sql);
			int cnt = rs.getRow();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
//				if(rs.getDate("joindate") == date )
				memberDto.setJoindate(rs.getString("joindate"));
				
				
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberDto;
	}
	
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		String searchName = null;
//		String searchName = "안효인";
//		List<MemberDto> list=st.memberList(searchName);
//		System.out.println("회원번호\t이름\t아이디\t가입일");
//		System.out.println("-------------------------");
//		for(MemberDto memberDto : list) {
//			System.out.println(memberDto.getNo()
//					+"\t"+memberDto.getName()
//					+"\t"+memberDto.getId()
//					+"\t"+memberDto.getJoindate());
//		}
//		
		int no = 125;
//		int no = 210;
		
		MemberDto memberDto = st.memberSearch(no);
//		이름 : 홍길동
//		id : hong
//		if(가입일 == 오늘)
//		가입일 : 10:27:24(오늘)
//		elseif
//		가입일 : 19.04.25(오늘x)
//		10번 회원은 존재하지 않습니다.
		
		if(memberDto != null) {
			
			System.out.println("no : " + memberDto.getNo());
			System.out.println("id : " + memberDto.getId());
			System.out.println("name : " + memberDto.getName());
			System.out.println("joindate : " + memberDto.getJoindate());
			
	}else {
		System.out.println(no + "번 회원은 없습니다.");
	}
	
	
	}
}
