package com.canguang.service;

import com.canguang.model.Merchant;

public interface IMerchantService {
	
	/**
	 * 保存商家
	 * @param merchant
	 * @return
	 */
	boolean saveMerchant(Merchant merchant);

}
