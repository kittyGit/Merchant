package com.canguang.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canguang.dao.IAdminDao;
import com.canguang.model.Admin;

@Repository
public class AdminDao implements IAdminDao {

	@Autowired
	private SessionFactory factory;

	protected Session getCurrentSession() {
		return factory.getCurrentSession();

	}

	@Override
	public Admin login(String userName, String pwd) {
		Session session = getCurrentSession();
		Admin admin = (Admin) session.get(Admin.class, userName);
				return admin;
	}

}
