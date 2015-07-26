package com.canguang.service;

import com.canguang.model.Admin;
import com.canguang.model.Merchant;

public interface IAdminService {

	/**
	 * 商家登录
	 * 
	 * @param admin
	 *            管理员
	 * @return 商家管理員
	 */

	Admin login(String adminName, String adminPwd);

	/**
	 * 修改密码
	 * 
	 * @param oldPwd
	 *            原密码
	 * @param newPwd
	 *            新 密码
	 * @param confirmPwd
	 *            确认ID
	 * @param merchantId
	 *            绑定管理员
	 * @return
	 */
	boolean updatePassword(String newPwd,Merchant merchant);

}
