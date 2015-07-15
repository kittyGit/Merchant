package com.canguang.dao;

import com.canguang.model.Merchant;

public interface IMerchantDao {

	/**
	 * 保存新谈合同的商家
	 * 
	 * @param merchant
	 * @return mysql自动生成的Id
	 */
	Integer saveMerchant(Merchant merchant);

	/**
	 * 根据merchantCode查找商家
	 * 
	 * @param merchantCode
	 * @return
	 */
	Merchant findByCode(String merchantCode);
}
