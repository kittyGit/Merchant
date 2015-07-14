package com.canguang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.ICustomerDao;
import com.canguang.model.Customer;
import com.canguang.service.ICustomerService;

@Service
@Transactional
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {
		customer =customerDao.saveCustomer(customer);
		return customer ;
	}

}
