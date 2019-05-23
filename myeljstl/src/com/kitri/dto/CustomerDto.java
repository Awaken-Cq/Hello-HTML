package com.kitri.dto;

public class CustomerDto {
	
	
	private String id;
	private String pass;
	private String name;
	
	public CustomerDto(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	public CustomerDto() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString();	//미완
	}
	
	
	
}
