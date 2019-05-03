package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam")
public class MultiparameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] fruit = request.getParameterValues("fruit");
//		2. logic
		

//		3. response page
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<div>"+ name + "(" + id + ")님 안녕하세요.</div>");
		out.print("<div>당신이 좋아하는 과일은 ");
		if(fruit == null)
			out.println("없습니다</div>");
//		else if(fruit.length == 1)
//			out.println(fruit[0] + "입니다.</div>");
		else {
			String str = "";
			for(int i = 0; i< fruit.length;i++) {
				str += fruit[i]+", ";
			}
			str = str.substring(0, str.length()-2);
			out.println(str+"입니다.</div>");
		}
		out.println("</body>");
		out.println("</html>");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	
	}

}
