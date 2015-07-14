package com.canguang.controller;

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
	ModelAndView login(@RequestParam("merchantCode") String merchantCode) {

		ModelAndView mv = new ModelAndView("register");
	
		return mv;
	}
	
	@RequestMapping(method =RequestMethod.POST, value="/success.action")
	ModelAndView register(@RequestParam String customerName,
			String phoneNumber,String customerPwd,String confirmPwd){
		
		ModelAndView mv = null;
		
		Customer customer=new Customer();
		customer.setCustomerName(customerName);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerPwd(customerPwd);
		customer.setConfirmPwd(confirmPwd);
		customer=customerservice.saveCustomer(customer);
		
		if(customer!=null){
			mv=new ModelAndView("redirect:success");
		}else{
			mv = new ModelAndView("register");
		}
		return mv;
	}
}
