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

	/**
	 * 获取session
	 * 
	 * @return
	 */

	protected Session getCurrentSession() {
		return factory.getCurrentSession();

	}

	@Override
	public Admin login(String adminName, String adminPwd) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from Admin where adminName=:adminName and adminPwd=:adminPwd");
		query.setString("adminName", adminName);
		query.setString("adminPwd", adminPwd);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

	@Override
	public Admin updatePassword(String oldPwd, String newPwd, String confirmPwd, Integer merchantId) {
		Session session = getCurrentSession();
		Query query = session.createQuery(
				"update Admin set adminPwd= :newPwd and adminPwd= :confirmPwd where merchantId= :merchantId and adminPwd= :oldPwd");
		query.setString("oldPwd", oldPwd);
		query.setString("newPwd", newPwd);
		query.setString("confirmPwd", confirmPwd);
		query.setInteger("merchantId", merchantId);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}
}
