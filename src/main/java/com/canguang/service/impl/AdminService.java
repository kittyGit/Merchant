package com.canguang.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canguang.dao.IAdminDao;
import com.canguang.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {
	@Autowired
	private IAdminDao adminDao;

	@Override
	public boolean login(String userName, String pwd) {
		return true;
	}

}
