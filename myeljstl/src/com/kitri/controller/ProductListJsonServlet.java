package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;
import com.kitri.service.ProductService;

/**
 * Servlet implementation class ProductListJsonServlet
 */
@WebServlet("/productlistjson")
public class ProductListJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
//	1)요청전달데이터얻기
//	2)Model호출
//	3)결과를 Request Attribute로 추가
//	4)View로 이동
	
	public ProductService productService;

	
	public ProductListJsonServlet() {
		productService = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		///Json(android)
			List<Product> pd = null;
		pd = productService.findAll();

		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValueAsString(pd);
		request.setAttribute("productlist", mapper.writeValueAsString(pd));
		String path = "productlistjsonresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path.trim());
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
