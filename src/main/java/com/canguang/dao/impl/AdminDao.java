package com.canguang.dao.impl;

<<<<<<< HEAD
=======
import org.hibernate.Query;
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canguang.dao.IAdminDao;
import com.canguang.model.Admin;

@Repository
public class AdminDao implements IAdminDao {
<<<<<<< HEAD

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
=======
	
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
	public Admin merchantLogin(String adminName, String adminPwd) {
		Session session =getCurrentSession();
		Query query=session.createQuery("from Admin where adminName=:adminName,adminPwd=:adminPwd");
		query.setString(1, adminName);
		query.setString(2, adminPwd);
		Admin admin=(Admin) query.uniqueResult();
		return admin;
	}

	@Override
	public Admin superLogin(String adminName, String adminPwd) {
		Session session =getCurrentSession();
		Query query=session.createQuery("from Admin where adminName=:adminName,adminPwd=:adminPwd");
		query.setString(1, adminName);
		query.setString(2, adminPwd);
		Admin admin=(Admin) query.uniqueResult();
		return admin;
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
	}

}
