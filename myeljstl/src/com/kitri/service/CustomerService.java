package com.kitri.service;

import com.kitri.dao.CustomerDao;
import com.kitri.dto.CustomerDto;
import com.kitri.exception.NotFoundException;

public class CustomerService {
	private static CustomerService customerService;

	static {
		customerService = new CustomerService();

	}

	public static CustomerService getCustomerService() {
		return customerService;
	}

	public String login(String id, String pass) {
		String result = "-1";
		
		CustomerDto customer = null;
		if (id != null && pass != null) {
			try {
				customer = CustomerDao.getCustomerDao().selectById(id);
				if (pass.equals(customer.getPass())) {
					
					result = "1";
					
					return result;
				}
				
			} catch (NotFoundException e) {
				e.printStackTrace();
				
			}
		}
		return result;
	}

}
