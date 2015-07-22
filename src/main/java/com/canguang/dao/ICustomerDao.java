package com.canguang.dao;

import java.util.Date;
import java.util.List;

import com.canguang.model.Customer;

public interface ICustomerDao {

	/**
	 * 通过customerId 查找用户
	 * 
	 * @param id
	 * @return
	 */
	Customer findByCustomerId(Integer id);

	/**
	 * 保存用户
	 * 
	 * @param customer
	 * @return
	 */

	Integer saveCustomer(Customer customer);

	/**
	 * 查找所有用户
	 * 
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
	List<Customer> findByAddress(String registerAddress);

	/**
	 * 通过注册时间查找用户信息
	 * 
	 * @param time
	 *            注册时间
	 * @return
	 */
	List<Customer> findByTime(Date registerTimeStart, Date registerTimeEnd);

	/**
	 * 通过名字，号码，注册时间 查找用户信息
	 * 
	 * @param phoneNumber
	 *            手机号码
	 * @param name
	 *            店面名字
	 * @param registerTime
	 *            注册时间
	 * @return
	 */
	List<Customer> findByNumerAndAddressAndTime(String phoneNumber, String address, Date registerTimeStart,
			Date registerTimeEnd);
}
