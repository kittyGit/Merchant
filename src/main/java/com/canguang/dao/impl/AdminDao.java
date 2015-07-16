package com.canguang.dao.impl;

import org.hibernate.Query;
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

	/**
	 * 获取session
	 * 
	 * @return
	 */

	@Override
	public Admin merchantLogin(String adminName, String adminPwd) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from Admin where adminName=:adminName and adminPwd=:adminPwd ");
		query.setString("adminName", adminName);
		query.setString("adminPwd", adminPwd);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

	@Override
	public Admin superLogin(String adminName, String adminPwd) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from Admin where adminName=:adminName and adminPwd=:adminPwd and merchantId=:merchantId");
		query.setString("adminName", adminName);
		query.setString("adminPwd", adminPwd);
		query.setString("merchantId", null);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

}
