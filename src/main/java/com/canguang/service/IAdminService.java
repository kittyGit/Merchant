package com.canguang.service;

import com.canguang.model.Admin;

public interface IAdminService {
	/**
	 * 保存商家的管理员
	 * @param admin
	 * @return
	 */
	Admin saveAdmin(Admin admin);
	
	/**
	 * 商家登錄
	 * @param adminName 
	 * @param adminPwd
	 * @return
	 */
	boolean login(String adminName,String adminPwd);

}
