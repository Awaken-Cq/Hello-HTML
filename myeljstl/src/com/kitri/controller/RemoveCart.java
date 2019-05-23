package com.kitri.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class RemoveCart
 */
@WebServlet("/removecart")
public class RemoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveCart() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("removecart");
		
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		
		String path ="viewcartresult.jsp";
		
		response.sendRedirect(path);
		
	}


}
