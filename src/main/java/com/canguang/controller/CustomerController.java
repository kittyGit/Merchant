package com.canguang.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.CouponStatus;
import com.canguang.model.Customer;
import com.canguang.model.Merchant;
import com.canguang.service.ICustomerService;
import com.canguang.service.IMerchantService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerservice;
	@Autowired
	private IMerchantService merchantService;

	@RequestMapping(method = RequestMethod.GET, value = "/registerInput.action")
	ModelAndView login(@RequestParam("merchantCode") String merchantCode) {

		ModelAndView mv = new ModelAndView("register");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register.action")
	ModelAndView register(@RequestParam("customerName") String customerName,
			@RequestParam("customerPhoneNumber") String phoneNumber, @RequestParam("customerPwd") String customerPwd,
			@RequestParam("confirmPwd") String confirmPwd, Merchant merchant) {

		/**
		 * 当前时间
		 */
		Date registerTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		df.format(registerTime);

		ModelAndView mv = null;
		/**
		 * 判断商家是否存在
		 */
		boolean isMerchant = merchantService.saveMerchant(merchant, merchant.getCode());
		if (isMerchant) {
			Customer customer = new Customer();
			customer.setCustomerName(customerName);
			customer.setPhoneNumber(phoneNumber);
			customer.setCustomerPwd(customerPwd);
			customer.setConfirmPwd(confirmPwd);
			customer.setRegisterTime(registerTime);
			customer.setMerchant(merchant);
			customer.setRegisterAddress(merchant.getMerchantAddress());
			customer.setLevel(0);
			customer.setValidated(true);
			if (merchant.isCoupon()) {
				customer.setCoupon(0);
				customer.setPrice(merchant.getPrice());
				customer.setCouponStatus(CouponStatus.UNUSED);
			} else {
				customer.setCoupon(-1);
			}
			/**
			 * 保存註冊用戶
			 */
			customer = customerservice.saveCustomer(customer);
			if (customer != null) {
				mv = new ModelAndView("index");
			} else {
				mv = new ModelAndView("register");
			}
		}

		return mv;
	}
}
