package com.kitri.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.service.CustomerService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			String result = CustomerService.getCustomerService().login(id, pass);
			System.out.println(result+555);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user/loginresult.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		doGet(request, response);

		String act = request.getParameter("act");
		if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			String result = CustomerService.getCustomerService().login(id, pass);
			System.out.println(result+6666);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginresult.jsp");
			dispatcher.forward(request, response);
		}

	}

}
