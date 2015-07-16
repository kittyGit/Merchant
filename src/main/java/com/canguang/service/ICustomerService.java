package com.canguang.service;

import com.canguang.model.Customer;

public interface ICustomerService {

	/**
	 * 保存用户注册信息
	 * 
	 * @param customer
	 *            用户
	 * @param merchantCode
	 *            商家编码
	 * @return
	 */
	boolean saveCustomer(Customer customer, String merchantCode);
}
