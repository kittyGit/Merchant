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

	public boolean merchanLogin(String adminName, String adminPwd) {
		Admin admin = adminDao.merchantLogin(adminName,adminPwd);
 		if (admin != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean superLogin(String adminName, String adminPwd) {

		Admin admin = adminDao.superLogin(adminName, adminPwd);
		if (admin != null) {
			return true;
		}
		return false;
	}
}
