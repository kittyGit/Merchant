package com.canguang.service.impl;

<<<<<<< HEAD
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canguang.dao.IAdminDao;
=======
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.IAdminDao;
import com.canguang.model.Admin;
import com.canguang.model.Merchant;
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
import com.canguang.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {
<<<<<<< HEAD
=======

>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
	@Autowired
	private IAdminDao adminDao;

	@Override
<<<<<<< HEAD
	public boolean login(String userName, String pwd) {
		return true;
	}

=======
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
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
}
