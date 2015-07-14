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
	private SessionFactory sessionFactory;

	/**
	 * 获取session
	 * @return
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Customer saveCustomer(Customer customer) {

		Session session=getCurrentSession();
		
		session.save(customer);
		return customer;
	}

}
