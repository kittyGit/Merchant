package com.canguang.dao;

import com.canguang.model.Store;

public interface IStoreDao {

	/**
	 * 通过storeName为商家添加店面
	 * 
	 * @param storeName
	 *            店面名
	 * @return 店面
	 */
	Integer saveStore(Store store);

}
