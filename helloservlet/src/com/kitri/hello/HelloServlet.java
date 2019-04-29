package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//어노테이션 servlet 3부터는 따로 web.xml파일에 설정을 기입할 필요없이 아래와 같이 @W~양식으로 간단히 지정
//확인은 Deployment Descriptor - Servlet Mappings에서 확인
@WebServlet("/hs")	
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		Hello Servlet!!!<br>");
		out.println("		안녕 서블릿!!!");
		out.println("	</body>");
		out.println("</html>");
		
	}



}
