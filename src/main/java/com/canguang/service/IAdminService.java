package com.canguang.service;

import com.canguang.model.Admin;

public interface IAdminService {

	/**
	 * 商家登录
	 * @param admin 管理员
	 * @return 商家管理員
	 */

    Admin login(String adminName,String adminPwd);
    
}
