package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.guestbook.dao.GuestBookDao;
import com.kitri.guestbook.dto.GuestBookDto;

@WebServlet({ "/GuestBookWrite", "/guestbookwrite" })
public class GuestBookWriteYou extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GuestBookDao dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new GuestBookDao();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글쓰기에 진입함");
		request.setCharacterEncoding("utf-8");
		int result = 0;
		
		GuestBookDto guestaBookDto = new GuestBookDto();
		guestaBookDto.setName(request.getParameter("name"));
		guestaBookDto.setSubject(request.getParameter("subject"));
		guestaBookDto.setContent(request.getParameter("content"));
		
		result = dao.insert(guestaBookDto);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		if(result != 0) {
			//성공
			out.println(guestaBookDto.getName() + " 님의 방명록이 성공적으로 기록되었습니다.<br>");
			out.println("<a href='/guestbookservlet/guestbooklist'>리스트 보기</a>");			
		} else {
			out.println("<font size='15' color='red'>");
			out.println("서버 문제로 방명록 등록이 실패하였습니다.");
			out.println("다음에 다시 시도하세요.");
			out.println("<a href='/guestbookservlet/guestbookwrite'>리스트 보기</a>");	
			out.println("</font>");
		}
		
		out.println("	</body>");
		out.println("</html>");

	}

}