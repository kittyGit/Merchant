package com.canguang.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	public Admin findByNameAndPassword(String adminName, String adminPwd) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from Admin where adminName=:adminName and adminPwd=:adminPwd");
		query.setString("adminName", adminName);
		query.setString("adminPwd", adminPwd);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

	@Override
	public boolean updatePassword(String newPwd, Admin admin) {

		Session session = getCurrentSession();
		Query query = session
				.createQuery("update Admin set adminPwd = :newPwd where adminId= :adminId");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("newPwd", newPwd);
		paramMap.put("adminId", admin.getAdminId());
		for (Entry<String, Object> paramEntry : paramMap.entrySet()) {
			query.setParameter(paramEntry.getKey(), paramEntry.getValue());
		}

		int updatedRows = query.executeUpdate();

		/*
		 * 如果受影响的记录大于1，表示更新成功
		 */
		if (updatedRows >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public void save(Admin admin) {
		getCurrentSession().save(admin);
	}
}
