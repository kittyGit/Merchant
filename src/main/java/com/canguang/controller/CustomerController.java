package com.canguang.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Customer;
import com.canguang.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerservice;

	@RequestMapping(method = RequestMethod.GET, value = "/registerInput.action")
	ModelAndView registerInput(@RequestParam("merchantCode") String merchantCode) {

		ModelAndView mv = new ModelAndView("register");

		return mv;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/register.action")
	ModelAndView register(@RequestParam("customerName") String customerName,
			@RequestParam("customerPhoneNumber") String phoneNumber,
			@RequestParam("customerPwd") String customerPwd,
			@RequestParam("confirmPwd") String confirmPwd,
			@RequestParam("customerPwd") String merchantCode) {
		
		
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerPwd(customerPwd);
		customer.setConfirmPwd(confirmPwd);
		Date registerTime = new Date();
		customer.setRegisterTime(registerTime);
		customer.setLevel(0);
		customer.setValidated(true);

		/**
		 * 保存註冊用戶
		 */
		boolean success = customerservice.saveCustomer(customer, merchantCode);
		ModelAndView mv = null;
		if (success) {
			mv = new ModelAndView("index");
		} else {
			mv = new ModelAndView("register");
		}
		return mv;
	}
}
