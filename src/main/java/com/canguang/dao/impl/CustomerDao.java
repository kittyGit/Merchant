package com.canguang.dao.impl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
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
	public List<Customer> findByNumerAndAddressAndTime(String phoneNumber, String address, Date registerTimeStart,
			Date registerTimeEnd) {
		Session session = getCurrentSession();
		
		String hql = "FROM Customer WHERE 1 = 1";
		
		Map<String, Object> paramMap = new HashMap<>();
		if (StringUtils.isNotBlank(phoneNumber)) {
			hql = hql + " AND phoneNumber LIKE :phoneNumber";
			paramMap.put("phoneNumber", MessageFormat.format("%{0}%", phoneNumber));
		}

		if (StringUtils.isNotBlank(address)) {
			hql = hql + " AND registerAddress LIKE :address";
			paramMap.put("address", MessageFormat.format("%{0}%", address));
		}
		
		if (registerTimeStart != null) {
			hql = hql + " AND registerTime >= :registerTimeStart";
			paramMap.put("registerTimeStart", registerTimeStart);
		}

		if (registerTimeEnd != null) {
			hql = hql + " AND registerTime <= :registerTimeEnd";
			paramMap.put("registerTimeEnd", registerTimeEnd);
		}
		
		Query query = session.createQuery(hql);
		for(Entry<String, Object> paramEntry : paramMap.entrySet()) {
			query.setParameter(paramEntry.getKey(), paramEntry.getValue());
		}
		
		List<Customer> customers = query.list();
		
		return customers;
	}

}
