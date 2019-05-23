package com.kitri.service;

import java.util.List;
import com.kitri.dto.Product;
import com.kitri.dao.ProductDao;

public class ProductService {

	private ProductDao dao;
	
	public ProductService() {
		dao = new ProductDao();
		
	}
	
	public List<Product>findAll(){
		
		return dao.selectAll();
	}

	public Product findNo(String pid) {

		return dao.selectId(pid);
	}
	
	
	
	
	
	
	
}
