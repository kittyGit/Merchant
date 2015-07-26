package com.canguang.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canguang.dao.IAdminDao;
import com.canguang.model.Admin;
import com.canguang.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public Admin login(String adminName, String adminPwd) {
		Admin admin = adminDao.findByNameAndPassword(adminName, adminPwd);
		return admin;
	}

	@Override
	public boolean updatePassword(String newPwd, Admin admin) {

		if (adminDao.updatePassword(newPwd, admin)) {
			return true;
		}

		return false;
	}
}
