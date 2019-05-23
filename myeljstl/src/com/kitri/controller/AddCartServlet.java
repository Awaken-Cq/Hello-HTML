package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;

import com.kitri.dto.Product;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCartServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("addcart로이동");
		// 장바구니는 map구조로 만든다.
		// key : Product / value : 수량 -> key
		String no = request.getParameter("no");
		String quantity = request.getParameter("cnt");
		HttpSession session = request.getSession();

		Map<Product, Integer> c = (Map) session.getAttribute("cart");
		if (c == null) {
			c = new HashMap<>();
			session.setAttribute("cart", c);
		}
		Product p = new Product();
		p.setProduct_no(no);
//		장바구니에 해당상품이 존재하는가 확인
		int intQuantity = Integer.parseInt(quantity);
		Integer inte = c.get(p);
		if(inte != null) {//존재하면 수량을 합산.
			intQuantity += inte.intValue();
		}
		
//		장바구니에 상품, 수량 추가
		c.put(p, intQuantity);
		
		String path = "/addcartresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

		System.out.println("장바구니 내용");
		Set<Product> keys = c.keySet();
		for (Product key : keys) {
			int q = c.get(key);
			System.out.println("상품번호 : " + key.getProduct_no() + ", 수량 : " + c.get(key) );
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
