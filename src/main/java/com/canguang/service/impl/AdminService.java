package com.canguang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.IAdminDao;
import com.canguang.model.Admin;
import com.canguang.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {
	
	@Autowired
	private IAdminDao adminDao;	

	@Override
	public Admin saveAdmin(Admin admin) {
		
		return adminDao.saveAdmin(admin);
	}

	@Override
	public boolean login(String adminName, String adminPwd) {
		Admin admin=adminDao.login(adminName, adminPwd);
		if(admin!=null){
			return true;
		}
		return false;
	}

}
