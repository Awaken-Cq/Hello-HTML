package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/singleparam")
public class SingleparameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.data get
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
//		2.logic
		String color = age == 10? "pink" : "cyan";
//		3.response page : name(id)님 안녕하세요.
//		10대면 아이디 핑크색 아니면 아이디 카얀
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");		
		out.println("<body>");		
		out.println("<div>" + name + "(<font color=\"" + color + "\">" + id + "</font>)님 안녕하세요.</div>");		
		out.println("</body>");		
		out.println("</html>");		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1.data get
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
//		2.logic
		String color = age == 10? "pink" : "cyan";
//		3.response page : name(id)님 안녕하세요.
//		10대면 아이디 핑크색 아니면 아이디 카얀
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");		
		out.println("<body>");		
		out.println("<div>" + name + "(<font color=\"" + color + "\">" + id + "</font>)님 안녕하세요.</div>");		
		out.println("</body>");		
		out.println("</html>");		
	
	}

}
