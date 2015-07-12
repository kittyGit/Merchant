package com.canguang.service.impl;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.IUserDao;
import com.canguang.model.User;
import com.canguang.service.IUserService;

/**
 * 可以用@component，但@Service更加清晰
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	public boolean findByName(String username) {
		User user = userDao.findByUsername(username);

		logger.debug(MessageFormat.format("根据用户名{0}查询结果为{1}", username, user));

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}
}
