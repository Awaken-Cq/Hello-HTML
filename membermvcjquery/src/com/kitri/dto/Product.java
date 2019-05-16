package com.kitri.dto;

public class Product {
	
	public Product() {
		
		
	}

	public Product(String product_no, String product_name, int product_price, String product_detail,
			ProductCategory productCategory) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_detail = product_detail;
		this.productCategory = productCategory;
	}

	private String product_no;
	private String product_name;
	private int product_price;
	private String product_detail;
	private ProductCategory productCategory;
	
	public String getProduct_no() {
		return product_no;
	}

	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	
	
}
