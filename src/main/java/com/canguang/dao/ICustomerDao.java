package com.canguang.dao;

import java.util.Date;
import java.util.List;

import com.canguang.model.Customer;
import com.canguang.model.Merchant;

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
	 * 通过名字，号码，注册时间 查找用户信息
	 * 
	 * @param phoneNumber
	 *            电话号码
	 * @param address
	 *            店面
	 * @param registerTimeStart
	 *            注册时间
	 * @param registerTimeEnd
	 *            注册时间
	 * @param merchant
	 *            对应商家
	 * @param pageNo
	 *            页数
	 * @param perPageSize
	 *            每页显示多少行
	 * @return
	 */
	List<Customer> findByNumerAndAddressAndTime(String phoneNumber,
			String address, Date registerTimeStart, Date registerTimeEnd,
			Merchant merchant, int pageNo, int perPageSize);

	/**
	 * 计算总页数
	 * 
	 * @param phoneNumber
	 * @param address
	 * @param registerTimeStart
	 * @param registerTimeEnd
	 * @param merchant
	 * @param pageNo
	 * @param perPageSize
	 * @return
	 */
	int countPageSize(String phoneNumber, String address,
			Date registerTimeStart, Date registerTimeEnd, Merchant merchant,
			int perPageSize);

	/**
	 * 通过电话号码查找用户信息
	 * 
	 * @param phoneNumber
	 * @param merchant
	 * @return
	 */
	List<Customer> findByPhoneNumber(String phoneNumber, Merchant merchant);

}
