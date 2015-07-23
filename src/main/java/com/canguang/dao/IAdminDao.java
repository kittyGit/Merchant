package com.canguang.dao;

import com.canguang.model.Admin;

public interface IAdminDao {

	/**
	 * 管理员登录
	 * 
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	Admin login(String adminName, String adminpwd);
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @return
	 */
	Admin updatePassword(String oldPwd,String newPwd,String confirmPwd,Integer merchantId);
}
