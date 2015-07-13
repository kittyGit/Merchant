package com.canguang.dao;

import com.canguang.model.Customer;

public interface ICustomerDao {

	Customer findByCustomerId(Integer id);

	Customer register(String customerName, String pwd, String phoneNumber,
			String merchantCode);

}
