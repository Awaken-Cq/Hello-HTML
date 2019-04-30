package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String color;
	
    public Gugudan() {

    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<div align=\"center\">");
			out.println("<h2>*** 구구단 ***");
			out.println("<table align=\"center\" width=\"600\" height=\"400\" border = 2>");
			for(int i = 1 ; i<10 ; i++) {
				out.println("<tr>");
				for(int j = 2 ; j<10 ; j++) {
					if(j%2 == 0)
						color = "red";
						else
						color = "blue";
					
				out.print("<td style=\"background-color:"+ color + "; color:white\">" + j + " * ");
				out.println(i + "=" + j*i + "</font></td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			
	}


}
