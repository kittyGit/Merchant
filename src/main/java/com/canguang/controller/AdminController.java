package com.canguang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	/**
	 * 商家管理登录
	 * 
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/adminLogin.action")
	ModelAndView adminLogin(@RequestParam("adminName") String adminName,
			@RequestParam("adminName") String adminPwd) {

		ModelAndView mvc = new ModelAndView("adminLogin");
		if (adminService.login(adminName, adminPwd)) {
			mvc = new ModelAndView("admin");
		} else {
			mvc = new ModelAndView("adminLogin");
		}
		return mvc;

	}

}
