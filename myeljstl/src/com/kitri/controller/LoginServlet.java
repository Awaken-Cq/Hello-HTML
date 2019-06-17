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
			//요청헤더에서 JSESSIONID라는 쿠키 존재  --no--  쿠키생성(이름:JSESSIONID, 값:유일한값)
//				.. --yes--...					|	  HttpSession 객체생성
//			쿠키에 해당하는 HttpSession객체 찾기		|	  인스턴스변수 id값은 쿠키값으로 채움
			HttpSession session = request.getSession();
			session.removeAttribute("loginInfo");
			if(result.equals("1")) { // 성공
				session.setAttribute("loginInfo", id);
			}
			request.setAttribute("result", result);
			System.out.println("dfsdfsdafsdf");
			System.out.println(result);
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
