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

		Merchant isMerchant = merchantDao.saveMerchant(merchant);
		if (isMerchant != null) {
			return true;
		} else {
			return false;
		}
	}

}
