package com.canguang.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canguang.dao.ICustomerDao;
import com.canguang.model.Customer;

@Repository
public class CustomerDao implements ICustomerDao {

	@Autowired
	private SessionFactory factory;

	protected Session getCurrentSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Customer findByCustomerId(Integer id) {

		Session session = getCurrentSession();
		Customer customer =(Customer) session.get(Customer.class, id);
		return customer;
	}

	@Override
	public Customer register(String customerName, String pwd,
			String phoneNumber, String merchantCode) {
		return null;
	}

}
