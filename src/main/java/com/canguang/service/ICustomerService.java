package com.canguang.service;

import java.util.Date;
import java.util.List;

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

	/**
	 * 查找所有的用户注册的信息
	 * 
	 * @param customers
	 * @return
	 */
	List<Customer> findAll();

	/**
	 * 通过手机号码查找用户信息
	 * 
	 * @param phoneNumber
	 *            手机号码
	 * @return
	 */
	List<Customer> findByPhoneNumber(String phoneNumber);

	/**
	 * 通过店面名字查找用户信息
	 * 
	 * @param name
	 *            店面名字
	 * @return
	 */
	List<Customer> findByName(String name);

	/**
	 * 通过注册时间查找用户信息
	 * 
	 * @param time
	 *            注册时间
	 * @return
	 */
	List<Customer> findByTime(Date registerTime);

	/**
	 * 通过名字，号码，注册时间查找商家
	 * 
	 * @param phoneNumber
	 *            手机号码
	 * @param name
	 *            店面名字
	 * @param registerTime
	 *            注册时间
	 * @return
	 */
	List<Customer> findByNumerAndNameAndTime(String phoneNumber, String name,
			Date registerTime);

}
