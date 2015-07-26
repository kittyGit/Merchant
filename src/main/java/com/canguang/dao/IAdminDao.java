package com.canguang.dao;

import com.canguang.model.Admin;

public interface IAdminDao {

	/**
	 * 根据用户名和密码查找
	 * 
	 * @param adminName
	 *            用户名
	 * @param adminPwd
	 *            密码
	 * @return
	 */
	Admin findByNameAndPassword(String adminName, String adminpwd);

	/**
	 * 修改密码
	 * 
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @return
	 */
	boolean updatePassword(String newPwd, Admin admin);

	void save(Admin admin);
}
