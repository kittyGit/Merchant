package com.canguang.dao;

import java.util.List;

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

	/**
	 * 根据MerchatId查找商家
	 * 
	 * @param MerchantId
	 * @return
	 */
	Merchant findById(Integer merchantId);

	/**
	 * name模糊查找
	 * 
	 * @param name
	 * @return
	 */
	List<Merchant> findByNameLike(String name);

	/**
	 * 查找所有商家
	 * 
	 * @return
	 */
	List<Merchant> findAll();
}
