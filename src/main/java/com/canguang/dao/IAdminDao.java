package com.canguang.dao;

import com.canguang.model.Admin;

public interface IAdminDao {
	
	Admin login(String userName,String pwd);


	/**
	 * 商家管理员登录
	 * @param adminName 
	 * @param adminPwd
	 * @return
	 */
	Admin merchantLogin(String adminName,String adminPwd);
	
	
	/**
	 * 餐广传媒管理员
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	Admin superLogin(String adminName,String adminPwd);
	
}
