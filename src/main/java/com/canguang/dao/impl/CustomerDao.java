package com.canguang.dao.impl;

import java.util.Date;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		Session session = getCurrentSession();
		Query query = session.createQuery(" from Customer");
		List<Customer> customers = query.list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from Customer where phoneNumber=:phoneNumber");
		query.setString("phoneNumber", phoneNumber);
		List<Customer> customers = (List<Customer>) query.list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByAddress(String registerAddress) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from Customer where registerAddress=:registerAddress");
		query.setString("registerAddress", registerAddress);
		List<Customer> customers = (List<Customer>) query.list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByTime(Date registerTimeStart, Date registerTimeEnd) {
		Session session = getCurrentSession();
		Query query = session.createQuery(
				"from Customer where registerTime >= :registerTimeStart and registerTime <= :registerTimeEnd");
		query.setDate("registerTimeStart", registerTimeStart);
		query.setDate("registerTimeEnd", registerTimeEnd);
		List<Customer> customers = query.list();
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByNumerAndAddressAndTime(String phoneNumber, String address, Date registerTimeStart,
			Date registerTimeEnd) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from Customer where phoneNumber=:phoneNumber and registerAddress= :address "
				+ "and registerTime >= :registerTimeStart and registerTime <= :registerTimeEnd ");
		query.setString("phoneNumber", phoneNumber);
		query.setString("address", address);
		query.setDate("registerTimeStart", registerTimeStart);
		query.setDate("registerTimeEnd", registerTimeEnd);
		List<Customer> customers = query.list();
		return customers;
	}

}
