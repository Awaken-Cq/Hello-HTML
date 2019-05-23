package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;

@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
    
	public ViewCartServlet() {
    productService = new ProductService();	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		1)세션얻기
		HttpSession session = request.getSession();
//		2)세션속성중 'cart'속성얻기
		Map<Product, Integer> c = (Map) session.getAttribute("cart");
		Map<Product, Integer> rc = new HashMap<>();
		if(c != null) {
			Set<Product>keys = c.keySet();
			for(Product p: keys) {
				String no = p.getProduct_no();
				
			//	try {
				Product p1 = productService.findNo(no);
				int quantity = c.get(p1);
				rc.put(p1, quantity);
			//	}catch(NotFoundException e) {
				//	e.getMessage("오류가 발생했당.");
			//	}
			}
			request.setAttribute("rcart", rc);
			String path = "/viewcartresult.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		
	}


}
	
}
