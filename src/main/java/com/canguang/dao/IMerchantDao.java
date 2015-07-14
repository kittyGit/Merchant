package com.canguang.dao;

import com.canguang.model.Merchant;

public interface IMerchantDao {
	
	/**
	 * 保存新谈合同的商家
	 * @param merchant
	 * @return
	 */
	Merchant saveMerchant(Merchant merchant);

}
