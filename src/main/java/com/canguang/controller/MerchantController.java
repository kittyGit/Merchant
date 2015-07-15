package com.canguang.controller;

import java.text.SimpleDateFormat;
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
	@RequestMapping(value = "/merchant.action")
	ModelAndView addAdminInput() {
		ModelAndView mvc = new ModelAndView("addMerchant");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showMerchant.action")
	ModelAndView addAdmin(@RequestParam("name") String merchantName, @RequestParam("address") String address,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("coupon") boolean coupon,
			@RequestParam("price") String price,
			@RequestParam("creator") String creator) {
		ModelAndView mvc = null;

		// 获取当前日期
		Date creationTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		df.format(creationTime);

		String code = "6";
		Merchant merchant = new Merchant();
		merchant.setMerchantName(merchantName);
		merchant.setMerchantAddress(address);
		merchant.setPhoneNumber(phoneNumber);
		merchant.setCreator(creator);
		merchant.setCreationTime(creationTime);
		merchant.setCode(code);
		if (coupon) {
			merchant.setCoupon(true);
			merchant.setPrice(price);
		} else {
			merchant.setCoupon(false);
			merchant.setPrice(null);
		}

		if (merchantservice.saveMerchant(merchant,code)) {
			mvc = new ModelAndView("index");
		}else{
			
			mvc = new ModelAndView("addMerchant");
		}

		return mvc;
	}

}
