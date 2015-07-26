package com.canguang.service;

import com.canguang.model.Admin;

public interface IAdminService {

	/**
	 * 商家或者超级管理员登陆
	 * 
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	Admin login(String adminName, String adminPwd);

	/**
	 * @param newPwd
	 * @param admin
	 * @return
	 */
	boolean updatePassword(String newPwd, Admin admin);

}
