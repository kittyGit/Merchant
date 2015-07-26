package com.canguang.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canguang.dao.IAdminDao;
import com.canguang.model.Admin;
import com.canguang.model.Merchant;
import com.canguang.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public Admin login(String adminName, String adminPwd) {

		Admin admin = adminDao.login(adminName, adminPwd);
		return admin;
	}

	@Override
	public boolean updatePassword(String newPwd, Merchant merchant) {

		if (adminDao.updatePassword(newPwd, merchant)) {
			return true;
		}

		return false;
	}
}
