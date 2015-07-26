package com.canguang.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canguang.dao.IStoreDao;
import com.canguang.model.Store;

@Repository
public class StoreDao implements IStoreDao {

	@Autowired
	private SessionFactory factory;

	protected Session getCurrentSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Integer saveStore(Store store) {
		Session session = getCurrentSession();
		return (Integer) session.save(store);
	}

}
