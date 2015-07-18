package com.canguang.service;

import java.util.List;

import com.canguang.model.Merchant;

public interface IMerchantService {

	/**
	 * 保存商家
	 * 
	 * @param merchant
	 * @return
	 */
	boolean saveMerchant(Merchant merchant);

	/**
	 * 根据merchantCode查找商家
	 * 
	 * @param merchantCode
	 * @return
	 */
	boolean findByCode(String merchantCode);

	/**
	 * 根据MerchatId查找商家
	 * 
	 * @param MerchantId
	 * @return
	 */
	boolean findById(Integer MerchantId);

	/**
	 * 根据name查找商家
	 * 
	 * @param name
	 * @return
	 */
	List<Merchant> findByName(String name);

	/**
	 * 查找所有的商家
	 * 
	 * @return
	 */
	List<Merchant> findAll();
}
