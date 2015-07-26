package com.canguang.dao.impl;

import java.text.MessageFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canguang.dao.IUserDao;
import com.canguang.model.User;

/**
 * 可以用@component，但@Repository更加清晰
 */
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = LoggerFactory.getLogger(UserDao.class);

	/**
	 * 获取Session
	 * 
	 * @return
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User findByUsername(String username) {

		logger.debug(MessageFormat.format("传入用户名{0}", username));

		Session session = getCurrentSession();
		Query query = session
				.createQuery("from User where username = :username");
		query.setString("username", username);

		User user = (User) query.uniqueResult();

		return user;
	}
}
