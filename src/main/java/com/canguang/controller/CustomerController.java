package com.canguang.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> 1de497530cb9029c314a51efaacd75736514b959
=======
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
<<<<<<< HEAD
import com.canguang.dto.CustomerDto;

@Controller
//表示请求url
@RequestMapping("/customer")
public class CustomerController {
	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/registerInput.action")
	ModelAndView registerInput(@RequestParam("merchantCode") String merchantCode) {

		//表示响应
		ModelAndView mv = new ModelAndView("register");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setMerchantCode(merchantCode);
		mv.addObject("command", customerDto);
		return mv;
	}

	@RequestMapping(method=RequestMethod.POST,value="/register.action")
	ModelAndView register(CustomerDto command) {
		ModelAndView mv = new ModelAndView("redirect:registerResult");
		
		return mv;

	}

=======
=======
import com.canguang.model.Customer;
import com.canguang.service.ICustomerService;

>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
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
<<<<<<< HEAD
>>>>>>> 1de497530cb9029c314a51efaacd75736514b959
=======

	@RequestMapping(method = RequestMethod.POST, value = "/register.action")
	ModelAndView register(@RequestParam("customerName") String customerName,
			@RequestParam("customerPhoneNumber") String phoneNumber,
			@RequestParam("customerPwd") String customerPwd,
			@RequestParam("confirmPwd") String confirmPwd,
			@RequestParam("customerPwd") String merchantCode) {

		/**
		 * 当前时间
		 */
		Date registerTime = new Date();

		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerPwd(customerPwd);
		customer.setConfirmPwd(confirmPwd);
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
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
}
