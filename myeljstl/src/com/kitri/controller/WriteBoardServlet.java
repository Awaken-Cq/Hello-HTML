package com.kitri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;
import com.kitri.service.RepBoardService;

/**
 * Servlet implementation class WriteBoardServlet
 */
@WebServlet("/writeboard")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       RepBoardService repBoardService;
    public WriteBoardServlet() {
        super();
        repBoardService = new RepBoardService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("writeboardservlet으로 이동");
		String board_subject = request.getParameter("subject");
		String board_writer = request.getParameter("writer");
		String board_password = request.getParameter("password");
		String board_contents = request.getParameter("contents");
		RepBoardDto repBoardDto = new RepBoardDto();
		repBoardDto.setBoard_subject(board_subject);
		repBoardDto.setBoard_writer(board_writer);
		repBoardDto.setBoard_password(board_password);
		repBoardDto.setBoard_contents(board_contents);
//		String result = "";
		try {
			
			repBoardService.write(repBoardDto);
			request.setAttribute("result","글쓰기 성공");
		} catch (AddException e) {
			e.printStackTrace();
			request.setAttribute("result","글쓰기 실패");
		}
		
		String path = "/writeresult.jsp";
		//request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	
	}

}
