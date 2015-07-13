package com.canguang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

}
