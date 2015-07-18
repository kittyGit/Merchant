package com.canguang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Merchant;
import com.canguang.service.IMerchantService;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	private IMerchantService merchantService;

	/**
	 * 添加商家管理员
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/manageMerchant.action")
	ModelAndView manageMerchant() {
		ModelAndView mvc = new ModelAndView("manageMerchant");
		return mvc;
	}

	/**
	 * 添加商家
	 * 
	 * @param merchantName
	 *            商家
	 * @param phoneNumber
	 *            练习方式
	 * @param coupon
	 *            是否使用优惠券
	 * @param price
	 *            优惠价格
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addMerchant.action")
	ModelAndView addMerchant(@RequestParam("name") String merchantName,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("coupon") boolean coupon,
			@RequestParam("price") String price) {

		ModelAndView mvc = null;
		Merchant newMerchant = new Merchant();
		newMerchant.setMerchantName(merchantName);
		newMerchant.setPhoneNumber(phoneNumber);
		Date creationTime = new Date();
		newMerchant.setCreationTime(creationTime);
		if (coupon) {
			newMerchant.setHasCoupon(true);
			newMerchant.setPrice(price);
		}

		if (merchantService.saveMerchant(newMerchant)) {
			mvc = new ModelAndView("index");
		} else {
			mvc = new ModelAndView("manageMerchant");

		}
		return mvc;
	}

	/**
	 * 查询商家
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/queryMerchant.action")
	ModelAndView queryMerchant(@RequestParam("name") String name) {
		ModelAndView mvc = new ModelAndView("manageMerchant");
		;
		List<Merchant> merchants = merchantService.findByName(name);
		mvc.addObject("merchants", merchants);
		return mvc;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addStoreInput.action")
	ModelAndView addStoreInput(@RequestParam("merchantId") Integer merchantId) {
		ModelAndView mvc = new ModelAndView("addStore");
		mvc.addObject("merchantId", merchantId);
		return mvc;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addStore.action")
	ModelAndView addStrore(@RequestParam("merchantId") Integer merchantId,
			@RequestParam("storeName") String storeName) {
		ModelAndView mvc = new ModelAndView("manageMerchant");

		return mvc;
	}

}
