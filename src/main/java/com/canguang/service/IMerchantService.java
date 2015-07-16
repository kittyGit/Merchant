package com.canguang.service;

import com.canguang.model.Merchant;

public interface IMerchantService {
	
	/**
	 * 保存商家
	 * @param merchant
	 * @return
	 */
	boolean saveMerchant(Merchant merchant);
	/**
	 * 根据merchantCode查找商家
	 * @param merchantCode
	 * @return
	 */
	 boolean findByCode(String merchantCode);
	 
		/**
		 * 根据MerchatId查找商家
		 * @param MerchantId
		 * @return
		 */
	boolean  findById(Integer MerchantId);
}
