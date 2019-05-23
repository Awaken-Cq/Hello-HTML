package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.service.OrderService;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService service;
   
    public AddOrderServlet() {
    	service = new OrderService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		장바구니정보가 주문테이블에 저장
		OrderInfo info = new OrderInfo();
		HttpSession session = request.getSession();
//		주문자아이디는 세션의 로그인 인포
		String id = (String)session.getAttribute("loginInfo");
		CustomerDto c = new CustomerDto();
		c.setId(id);
		info.setCustomer(c); //주문자id설정
//		장바구니 정보는 세션에 저장되어있는 카트의 정보값(상품번호, 수량 ->OrderLine에 설정)
		Map<Product, Integer>cart = (Map)session.getAttribute("cart");
		List<OrderLine> lines = new ArrayList<>();
		for(Product product : cart.keySet()) {
			OrderLine line = new OrderLine();
//			String no = product.getProduct_no();
//			System.out.println(no);
			int quantity = (Integer)cart.get(product);
//			상품번호, 수량 ->OrderLine에 설정
			line.setProduct(product);
			line.setOrder_quantity(quantity);
			lines.add(line);
		}
		info.setLines(lines);
		String result = "";
		
		try {
			service.addOrder(info);
			session.removeAttribute("cart"); //장바구니 비우기
			result = "1";
		} catch (AddException e) {
			result = "-1";
			e.printStackTrace();
		}
		String path = "/addorderresult.jsp";
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
