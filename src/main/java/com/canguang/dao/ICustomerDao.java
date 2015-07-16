package com.canguang.dao;

import com.canguang.model.Customer;

<<<<<<< HEAD
public interface ICustomerDao {

	Customer findByCustomerId(Integer id);

	Customer register(String customerName, String pwd, String phoneNumber,
			String merchantCode);
=======

public interface ICustomerDao {

	Integer saveCustomer(Customer customer);
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b

}
