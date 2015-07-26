package com.canguang.dao;

import com.canguang.model.Admin;
import com.canguang.model.Merchant;

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
	 * 
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @return
	 */
	boolean updatePassword(String newPwd, Merchant merchant);
}
