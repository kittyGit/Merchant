package com.canguang.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Admin;
import com.canguang.model.Customer;
import com.canguang.service.IAdminService;
import com.canguang.service.ICustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/loginInput.action")
	ModelAndView loginInput() {
		ModelAndView mvc = new ModelAndView("login");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.action")
	ModelAndView login(@RequestParam("adminName") String adminName, @RequestParam("adminPwd") String adminPwd,
			HttpSession session) {

		ModelAndView mvc = null;

		Admin admin = adminService.login(adminName, adminPwd);
		if (admin != null) {
			if (admin.getMerchant() != null) {
				mvc = new ModelAndView("merchantAdmin");
			} else {
				mvc = new ModelAndView("canGuangAdmin");
			}
			session.setAttribute("admin", admin);
		} else {
			mvc = new ModelAndView("login");
		}

		return mvc;
	}

	/**
	 * 验证用户是否有消费记录
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/verify.action")
	ModelAndView verify() {

		ModelAndView mvc = new ModelAndView("canGuangAdmin");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showVerifyCustomer.action")
	ModelAndView exchange(@RequestParam("phoneNumber") String phoneNumber) {
		ModelAndView mvc = new ModelAndView("canGuangAdmin");
		List<Customer> customerExchanges = customerService.findByPhoneNumber(phoneNumber);
		mvc.addObject("customerExchanges", customerExchanges);
		return mvc;
	}

	/**
	 * 查询用户交易记录
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/customerExchange.action")
	ModelAndView exchangeCustomer() {

		ModelAndView mvc = new ModelAndView("exchange");
		return mvc;
	}

	@SuppressWarnings("unused")
	@RequestMapping(method = RequestMethod.POST, value = "/showExchange.action")
	ModelAndView customersExchange(@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("registerAddress") String registerAddress,
			@RequestParam("registerTimer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date registerTime) {
		List<Customer> customerExchanges = null;
		if (!phoneNumber.equals("") && phoneNumber != null) {
			customerExchanges = customerService.findByPhoneNumber(phoneNumber);
		} else if (!registerAddress.equals("") && registerAddress != null) {
			customerExchanges = customerService.findByAddress(registerAddress);
		} else if (!registerTime.equals("") && registerTime != null) {
			customerExchanges = customerService.findByTime(registerTime);
		} else if (phoneNumber != null && registerAddress != null && registerTime != null) {
			customerExchanges = customerService.findByNumerAndAddressAndTime(phoneNumber, registerAddress,
					registerTime);
		}
		ModelAndView mvc = new ModelAndView("exchange");
		mvc.addObject("customerExchanges", customerExchanges);
		return mvc;
	}
}
