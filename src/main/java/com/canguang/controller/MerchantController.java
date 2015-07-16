package com.canguang.controller;

import java.util.Date;

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
	private IMerchantService merchantservice;

	/**
	 * 添加商家管理员
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/addMerchantInput.action")
	ModelAndView addMerchantInput() {
		ModelAndView mvc = new ModelAndView("addMerchant");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addMerchant.action")
	ModelAndView addMerchant(@RequestParam("name") String merchantName, @RequestParam("address") String address,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("coupon") boolean coupon,
			@RequestParam("price") String price, @RequestParam("creator") String creator)
				 {

		ModelAndView mvc = null;

		// 获取当前日期
		Date creationTime = new Date();

		Merchant newMerchant = new Merchant();
		newMerchant.setMerchantName(merchantName);
		newMerchant.setMerchantAddress(address);
		newMerchant.setPhoneNumber(phoneNumber);
		newMerchant.setCreator(creator);
		newMerchant.setCreationTime(creationTime);
		if (coupon) {
			newMerchant.setCoupon(true);
			newMerchant.setPrice(price);
		}

		if (merchantservice.saveMerchant(newMerchant)) {
			mvc = new ModelAndView("index");
		} else {
			mvc = new ModelAndView("addMerchant");

		}
		return mvc;
	}

}
