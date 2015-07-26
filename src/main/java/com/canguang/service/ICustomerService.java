package com.canguang.service;

import java.util.Date;
import java.util.List;

import com.canguang.model.Customer;
import com.canguang.model.Merchant;

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
	 * 通过手机号码验证
	 * @param phoneNumber
	 * @return
	 */
	List<Customer> findByPhoneNumber(String phoneNumber,Merchant merchant);

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
	List<Customer> findByNumerAndAddressAndTime(String phoneNumber, String Address, Date registerTimeStart,
			Date registerTimeEnd,Merchant merchant,int pageNo,int perPageSize);
	/**
	 *计算总页数
	 * @param phoneNumber
	 * @param Address
	 * @param registerTimeStart
	 * @param registerTimeEnd
	 * @param merchant
	 * @param pageNo
	 * @param perPageSize
	 * @return
	 */
	int countPageSize(String phoneNumber, String address, Date registerTimeStart,
			Date registerTimeEnd,Merchant merchant,int perPageSize);

}
