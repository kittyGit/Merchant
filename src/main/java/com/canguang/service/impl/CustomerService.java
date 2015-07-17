package com.canguang.service.impl;

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

		/**
		 * 判断商家是否存在
		 */
		Merchant merchant = merchantDao.findByCode(merchantCode);

		if (merchant != null) {
			customer.setMerchant(merchant);
			customer.setRegisterAddress(merchant.getMerchantAddress());
			if (merchant.isCoupon()) {
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
	public boolean findAll() {
		if(customerDao.findAll()!=null){
			return true;
		}
		return false;
	}

}
