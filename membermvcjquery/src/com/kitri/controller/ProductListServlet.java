package com.kitri.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;

import sun.security.util.DisabledAlgorithmConstraints;

@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProductService productService;
//	1)요청전달데이터얻기
//	2)Model호출
//	3)결과를 Request Attribute로 추가
//	4)View로 이동
	
	public ProductListServlet() {
		productService = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Product> pd = null;

	pd = productService.findAll();
	String path = "productlistresult.jsp";
	request.setAttribute("pd", pd);
	RequestDispatcher rd = request.getRequestDispatcher(path.trim());
	rd.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		doGet(request, response);
	}

}
