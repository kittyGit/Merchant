package com.canguang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET, value = "/registerInput.action")
	ModelAndView login(@RequestParam("merchantCode") String merchantCode) {

		ModelAndView mv = new ModelAndView("register");

		return mv;
	}
}
