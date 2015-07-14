package com.canguang.service;

import com.canguang.model.Customer;

public interface ICustomerService {
	/**
	 * 保存用户注册信息
	 * @param customerName 用户名
	 * @param phoneNumber 手机号码
	 * @param pwd 密码 
	 * @param ConfirmPwd  再次确认密码
	 * @return
	 */
	Customer saveCustomer(Customer customer);
}
