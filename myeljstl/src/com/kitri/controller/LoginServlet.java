package com.kitri.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.service.CustomerService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		System.out.println(act);
		if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String result = CustomerService.getCustomerService().login(id, pass);
			HttpSession session = request.getSession();
			session.removeAttribute("loginInfo");
			if(result.equals("1")) { // 성공
				session.setAttribute("loginInfo", id);
			}
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginresult.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);


	}

}
