package com.canguang.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canguang.dao.IMerchantDao;
import com.canguang.dao.IStoreDao;
import com.canguang.model.Merchant;
import com.canguang.model.Store;
import com.canguang.service.IStoreService;

@Service
@Transactional
public class StoreService implements IStoreService {

	@Autowired
	private IStoreDao storeDao;
	@Autowired
	private IMerchantDao merchantDao;

	@Override
	public boolean saveStore(Store store, Integer merchantId) {
		Merchant merchant = merchantDao.findById(merchantId);
		store.setStoreCode(UUID.randomUUID().toString());
		store.setMerchant(merchant);
		Integer storeId = storeDao.saveStore(store);
		if (storeId != null) {
			return true;
		}
		return false;
	}
}
