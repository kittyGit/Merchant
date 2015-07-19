package com.canguang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Admin;
import com.canguang.service.IAdminService;
import com.canguang.service.ICustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private ICustomerService customerservice;

	@RequestMapping(method = RequestMethod.GET, value = "/loginInput.action")
	ModelAndView loginInput() {
		ModelAndView mvc = new ModelAndView("login");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.action")
	ModelAndView login(@RequestParam("adminName") String adminName,
			@RequestParam("adminPwd") String adminPwd) {

		ModelAndView mvc = null;

		Admin admin = adminService.login(adminName, adminPwd);
		if (admin != null) {
			if (admin.getMerchant() != null) {
				mvc = new ModelAndView("merchantAdmin");
			} else {
				mvc = new ModelAndView("canGuangAdmin");
			}
		} else {
			mvc = new ModelAndView("login");
		}

		return mvc;
	}
	/**
	 * 查询会员
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/queryCustomer.action")
	ModelAndView querys(){
		ModelAndView mvc=new ModelAndView("merchantAdmin");
		return mvc;
	}
		
}
