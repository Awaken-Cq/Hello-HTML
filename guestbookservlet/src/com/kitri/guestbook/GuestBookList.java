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

@WebServlet("/gblist")
public class GuestBookList extends HttpServlet {
	int seq = 0;
	String name = "";
	String subject = "";
	String content = "";
	String logtime = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		content = "";
		subject = "";
		name = "";
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
//			String sql = "";
			StringBuffer sql = new StringBuffer("");
			sql.append("select seq, name, subject, content, logtime \n");
			sql.append("from guestbook \n");
			sql.append("order by seq desc");

			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"ko\">");
			out.println("<head>");
			out.println("<title>글목록</title>");
			out.println("<meta charset=\"utf-8\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
			out.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>");
			out.println(
					"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>");
			out.println("<script type=\"text/javascript\">");

			out.println("</script>");
			out.println("</head>");
			out.println("<body>");

			out.println("<div class=\"container\" align=\"center\">");
			out.println(" <div class=\"col-lg-8\" align=\"center\">");
			out.println(" <h2>글목록</h2>");
			out.println("<table class=\"table table-borderless\">");
			out.println("	<tr>");
			out.println(
					"		<td align=\"right\"><a href=\"/guestbookservlet/guestbook/write.html\"><button type=\"button\" class=\"btn btn-link\" onclick=\"/guestbook/write.html\" >글쓰기</button></a></td>");
			out.println("	</tr>");
			out.println(" </table>");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				out.println("<table class=\"table table-active\"> \n");
				out.println("    <tbody>\n");
				out.println("      <tr>\n");
				out.println("        <td>작성자 : " + rs.getString("name") + "</td>\n");
				out.println("        <td style=\"text-align: right;\">작성일 : " + rs.getString("logtime") + "</td>\n");
				out.println("      </tr>\n");
				out.println("      <tr>\n");
				out.println("        <td colspan=\"2\"><strong>" + rs.getString("seq") + "." + rs.getString("subject") + "</strong></td>\n");
				out.println("      </tr>\n");
				out.println("      <tr>\n");
				out.println("        <td colspan=\"2\">" + rs.getString("content") + "</td>\n");
				out.println("      </tr>\n");
				out.println("    </tbody>\n");
				out.println("  </table>\n");
			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		out.println("	  </div>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
