package com.canguang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.IMerchantDao;
import com.canguang.model.Merchant;
import com.canguang.service.IMerchantService;

@Service
@Transactional
public class MerchantService implements IMerchantService {

	@Autowired
	private IMerchantDao merchantDao;

	@Override
	public boolean saveMerchant(Merchant merchant) {
		
		merchant.setCode("6");
		
		Integer id = merchantDao.saveMerchant(merchant);
		if (id != null && id > 0) {
			return true;
		} else {
			return false;
		}
	}
}
