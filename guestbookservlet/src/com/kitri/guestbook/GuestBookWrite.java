package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gbwrite")
public class GuestBookWrite extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		1.data get(작성자, 제목, 내용)
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

//		2.logic(DB에 인설트)
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into guestbook(seq, name, subject, content, logtime) \n");
			sql.append("values(guestbook_seq.nextval, ?, ?, ?, sysdate)");

			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, name);
			ps.setString(2, subject);
			ps.setString(3, content);

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		3. response page(글목록)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		if(cnt == 0) {
		out.println("서버의 오류로 인하여 방명록 등록에 실패하였습니다.");
		out.println("잠시 후 다시 시도해 주시기 바랍니다.");
		}else {
		out.println("방명록이 등록되었습니다.");
//		out.println("<a href=\"/guestbookservlet/guestbook/list.html></a>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
