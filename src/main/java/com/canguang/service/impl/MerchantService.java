package com.canguang.service.impl;

import java.util.UUID;

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
	@Autowired
	private Merchant merchant;

	@Override
	public boolean saveMerchant(Merchant merchant) {

		merchant.setCode(UUID.randomUUID().toString());

		Integer id = merchantDao.saveMerchant(merchant);
		if (id != null && id > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean findByCode(String merchantCode) {
		merchant = merchantDao.findByCode(merchantCode);
		if (merchant != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findById(Integer MerchantId) {
		merchant = merchantDao.findById(MerchantId);
		if (merchant != null) {
			return true;
		}
		return false;
	}
}
