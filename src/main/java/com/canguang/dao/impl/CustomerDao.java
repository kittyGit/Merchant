package com.canguang.dao.impl;

import java.util.List;

import org.hibernate.Query;
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

	/**
	 * 获取session
	 * 
	 * @return
	 */

	protected Session getCurrentSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Customer findByCustomerId(Integer id) {

		Session session = getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	@Override
	public Integer saveCustomer(Customer customer) {
		Session session = getCurrentSession();
		return (Integer) session.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return null;
	}

	@Override
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		Session session=getCurrentSession();
		Query query=session.createQuery("from Customer where phoneNumber=:phoneNumer");
		query.setString("phoneNumber", phoneNumber);
		return null;
	}

	@Override
	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
