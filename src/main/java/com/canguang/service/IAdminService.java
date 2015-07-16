package com.canguang.service;

import com.canguang.model.Admin;
import com.canguang.model.Merchant;

public interface IAdminService {

	/**
	 * 商家登录
	 * @param admin 管理员
	 * @param merchant 商家登录绑定当前商家ID
	 * @return 商家管理員
	 */
	boolean merchanLogin(Admin admin,Merchant merchant);
	
	/**
	 * 餐广登录
	 * @param admin
	 * @return
	 */
    boolean superLogin(Admin admin);

}
