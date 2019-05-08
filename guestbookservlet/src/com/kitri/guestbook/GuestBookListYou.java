package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kitri.guestbook.dao.GuestBookDao;
import com.kitri.guestbook.dto.GuestBookDto;

@WebServlet({ "/GuestBookList", "/guestbooklist" })
public class GuestBookListYou extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GuestBookDao dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new GuestBookDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트 입장!");
		List<GuestBookDto> list = dao.selectAll();
//		for(GuestBookDto dto : list) {
//			System.out.println(dto);
//		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<title>글목록</title>");
		out.println("<meta charset='utf-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='/guestbookservlet/guestbook/test.css'>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>");
		out.println("<script type='text/javascript'>");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class='container' align='center'>");
		out.println("  <div class='col-lg-8' align='center'>");
		out.println("  <h2>글목록</h2>");
		out.println("  <table class='table table-borderless'>");
		out.println("  	<tr>");
		out.println("		<td align='right'><a href='/guestbookservlet/guestbook/write.html'><button type='button' class='btn btn-link' >글쓰기</button></a></td>");
		out.println("  	</tr>");
		out.println("  </table>");
		
		if(list.size() == 0) {
			out.println("<strong><h5>아직 방명록이 없습니다...... 글을 남겨주세요 ㅠㅠ</h5></strong>");
		}else {
			for(GuestBookDto dto : list) {
				out.println(writeListTable(dto));
			}
		}

		out.println("</body>");
		out.println("</html>");
	}

	private StringBuffer writeListTable(GuestBookDto dto) {
		StringBuffer tableHTML = new StringBuffer();
		tableHTML.append("<table class='table table-active'>");
		tableHTML.append(" <tbody>");
		tableHTML.append("  <tr>");
		tableHTML.append("   <td>작성자 : " + dto.getName() +  "</td>");
		tableHTML.append("   <td style='text-align: right;'>작성일 : " + dto.getLogtime() +"</td>");
		tableHTML.append(" </tr>");
		tableHTML.append("  <tr>");
		tableHTML.append("   <td colspan='2'><strong>" + dto.getSeq() +". " + dto.getSubject() + "</strong></td>");
		tableHTML.append("  </tr>");
		tableHTML.append("  <tr>");
		tableHTML.append("   <td colspan='2'>" + dto.getContent().replace("\n", "\n<br>") + "</td>");
		tableHTML.append(" </tr>");
		tableHTML.append("</tbody>");
		tableHTML.append("</table>");
		return tableHTML;
	}
}