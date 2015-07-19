package com.canguang.service;

import com.canguang.model.Store;

public interface IStoreService {
	boolean saveStore(Store store, Integer merchantId);

}
