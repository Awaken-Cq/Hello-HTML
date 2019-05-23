package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.OrderInfo;
import com.kitri.service.OrderService;


@WebServlet("/vieworder")
public class ViewOrder extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private OrderService orderService;   
	
    public ViewOrder() {
    	orderService = new OrderService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginInfo");
		
		List<OrderInfo> orderList = orderService.findById(id);
		request.setAttribute("orderlist", orderList);
		String path = "/vieworderresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}



}
