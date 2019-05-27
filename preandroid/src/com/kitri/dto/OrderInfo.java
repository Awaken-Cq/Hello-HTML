package com.kitri.dto;

import java.util.Date;
import java.util.List;

public class OrderInfo {


	private int order_no;
	private CustomerDto customer;
	private Date order_date; 
	private List<OrderLine> lines;
	
	
	
	public OrderInfo() {
	}
	
	public OrderInfo(int order_no, CustomerDto customer, Date order_date, List<OrderLine> lines) {
		super();
		this.order_no = order_no;
		this.customer = customer;
		this.order_date = order_date;
		this.lines = lines;
	}
	
	
	public int getOrder_no() {
		return order_no;
	}
	
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	
	public CustomerDto getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	
	public Date getOrder_date() {
		return order_date;
	}
	
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	public List<OrderLine> getLines() {
		return lines;
	}
	
	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
	}
}
