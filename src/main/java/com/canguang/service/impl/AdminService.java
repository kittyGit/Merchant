package com.canguang.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public boolean merchanLogin(Admin admin, Merchant merchant) {
		if (adminDao.merchantLogin(admin.getAdminName(), admin.getAdminPwd()) != null) {
			admin.setMerchant(merchant);
			admin.setCreationTime(new Date());
			admin.setSuperAdmin(false);
			return true;
			}
		return false;
	}

	@Override
	public boolean superLogin(Admin admin) {
		if (adminDao.superLogin(admin.getAdminName(), admin.getAdminPwd()) != null) {
			admin.setMerchant(null);
			admin.setCreationTime(new Date());
			admin.setSuperAdmin(true);
			return true;
			}
		return false;
	}
}
