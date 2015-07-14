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
	private SessionFactory sessionFactory;
	
	/**
	 * 获取session
	 * @return
	 */
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		
		Session session=getCurrentSession();
		session.save(admin);
		return admin;
	}

	@Override
	public Admin login(String adminName, String adminPwd) {
		Session session =getCurrentSession();
		Query query=session.createQuery("select * from Admin where adminName=:adminName,adminPwd=:adminPwd");
		query.setString(1, adminName);
		query.setString(2, adminPwd);
		Admin admin=(Admin) query.uniqueResult();
		return admin;
	}

}
