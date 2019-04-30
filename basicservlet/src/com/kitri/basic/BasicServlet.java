package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String name;
	int age;
	
	@Override
	public void init() throws ServletException{
		
		name = "노정탁";
		age = 28;
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("	<body>");
		String color = "";
		if(age < 18) {
			color = "red";
		}else {
			color = "steelblue";
		}
		out.println("		<font color=\"" + color + "\"> " +name  + "</font>(<font color=\"" + color + "\">" + age + "</font>)님 안녕하세요");
		out.println("	</body>");
		out.println("</html>");
		out.println("");
	}

}
