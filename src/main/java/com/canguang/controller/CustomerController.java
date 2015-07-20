package com.canguang.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Customer;
import com.canguang.service.ICustomerService;
import com.canguang.service.IMessageService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerservice;

	@Autowired
	private IMessageService messageService;

	@RequestMapping(method = RequestMethod.GET, value = "/registerInput.action")
	ModelAndView registerInput(
			@RequestParam("merchantCode") String merchantCode,
			@RequestParam("storeCode") String storeCode) {

		ModelAndView mv = new ModelAndView("register");
		// 等价于request.setAttribute("merchantCode", merchantCode);
		mv.addObject("merchantCode", merchantCode);
		mv.addObject("storeCode", storeCode);
		return mv;
	}

	/**
	 * 保存註冊用戶
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/register.action")
	ModelAndView register(
			@RequestParam("customerName") String customerName,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("customerPwd") String customerPwd,
			@RequestParam("merchantCode") String merchantCode,
			@RequestParam("merchantCode") String storeCode,
			@RequestParam(value = "vCode", required = false) String verifyCode,
			@RequestParam(value = "imageCode", required = false) String imageCode) {

		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerPwd(customerPwd);
		Date registerTime = new Date();
		customer.setRegisterTime(registerTime);
		customer.setLevel(0);
		boolean success = customerservice.saveCustomer(customer, merchantCode);
		ModelAndView mv = null;
		if (success) {
			mv = new ModelAndView("registerResult");
		} else {
			mv = new ModelAndView("register");
		}
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sendVerifyCode.action")
	@ResponseBody
	boolean sendVerifyCode(@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam(value = "username", required = false) String username, HttpSession session) {
		/*
		 * 生成验证码
		 */
		/*String verifyCode = messageService.generateAndSendVerifyCode(username,
				phoneNumber);*/
		String verifyCode = "123";
		/*
		 * 验证码发送成功
		 */
		if (verifyCode != null) {
			
			/*
			 * 把验证码放到Session中
			 * key: 手机号码
			 * value：验证码
			 */
			session.setAttribute(phoneNumber, verifyCode);
			return true;
		}
		/*
		 * 验证码发送失败
		 */
		return false;
	}
}
