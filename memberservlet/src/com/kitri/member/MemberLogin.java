package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		한글아이디를 받아와야할 경우 setCharcterEncoding 설정
		request.setCharacterEncoding("utf-8");
//		1. data get
//		받아올 데이터(id, password).
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		
//		2. logic
//		DB에 있는 아이디, 패스워드와 일치하는지 확인(select문)
//		맞을 시 아이디, 이름 불러오기.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");

			StringBuffer sql = new StringBuffer();
			sql.append("select name \n");
			sql.append("from member \n");
			sql.append("where id = ? and pass = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				name = rs.getString("name");
		
			
			
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs != null)
						rs.close();
					if(pstmt != null)
						pstmt.close();
					if(conn != null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
//		3. response page
//		name != null:  ~~님 환영합니다.
//		name == null : 아이디 또는 비밀번호를 확인해주세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		if(name != null) {
		out.println(name + "님 환영합니다 ^_^")	;
		}else {
		out.println("		<font color=\"red\">");
		out.println("		아이디 또는 비밀번호를 다시 확인하세요.");
		out.println("		등록되지 않은 아이디거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");	
		out.println("		</font>");
		out.println("		<a href=\"/memberservlet/user/login.html\">확인</a>");
		}
		out.println("	</body>");
		out.println("</html>");
		
		
		
		
	}

}
