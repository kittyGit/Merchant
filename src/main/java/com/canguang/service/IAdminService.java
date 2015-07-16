package com.canguang.service;



public interface IAdminService {

	/**
	 * 商家登录
	 * @param admin 管理员
	 * @param merchant 商家登录绑定当前商家ID
	 * @return 商家管理員
	 */
	boolean merchanLogin(String adminName, String adminPwd);
	
	/**
	 * 餐广登录
	 * @param admin
	 * @return
	 */
    boolean superLogin(String adminName, String adminPwd);

}
