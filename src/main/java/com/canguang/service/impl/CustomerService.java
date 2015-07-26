package com.canguang.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.ICustomerDao;
import com.canguang.dao.IMerchantDao;
import com.canguang.model.CouponStatus;
import com.canguang.model.Customer;
import com.canguang.model.Merchant;
import com.canguang.service.ICustomerService;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private IMerchantDao merchantDao;

	@Override
	public boolean saveCustomer(Customer customer, String merchantCode) {

		/*
		 * 判断商家是否存在
		 */
		Merchant merchant = merchantDao.findByCode(merchantCode);

		if (merchant != null) {
			customer.setMerchant(merchant);
			customer.setRegisterAddress(merchant.getMerchantName());
			customer.setRegisterTime(new Date());
			if (merchant.isHasCoupon()) {
				customer.setCoupon(0);
				customer.setPrice(merchant.getPrice());
				customer.setCouponStatus(CouponStatus.UNUSED);
			}

			Integer id = customerDao.saveCustomer(customer);
			if (id != null && id > 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = customerDao.findAll();
		return customers;
	}

	@Override
	public List<Customer> findByNumerAndAddressAndTime(String phoneNumber,
			String address, Date registerTimeStart, Date registerTimeEnd,
			Merchant merchant, int pageNo, int perPageSize) {
		List<Customer> customers = customerDao.findByNumerAndAddressAndTime(
				phoneNumber, address, registerTimeStart, registerTimeEnd,
				merchant, pageNo, perPageSize);
		return customers;
	}

	@Override
	public List<Customer> findByPhoneNumber(String phoneNumber,
			Merchant merchant) {
		List<Customer> cutomers = customerDao.findByPhoneNumber(phoneNumber,
				merchant);
		return cutomers;
	}

	@Override
	public int countPageSize(String phoneNumber, String address,
			Date registerTimeStart, Date registerTimeEnd, Merchant merchant,
			int perPageSize) {
		int pageSize = customerDao.countPageSize(phoneNumber, address,
				registerTimeStart, registerTimeEnd, merchant, perPageSize);
		return pageSize;
	}
}
