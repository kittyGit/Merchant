package com.canguang.dao;

import com.canguang.model.Customer;

public interface ICustomerDao {

	/**
	 * 通过customerId 查找用户
	 * @param id
	 * @return
	 */
	Customer findByCustomerId(Integer id);
	/**
	 * 保存用户
	 * @param customer
	 * @return
	 */

	Customer saveCustomer(Customer customer);

}
