package com.canguang.dao;

import com.canguang.model.Admin;

public interface IAdminDao {
	
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
	Admin login(String adminName,String adminPwd);
	
}
