package com.canguang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Admin;
import com.canguang.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	/**
	 * 添加商家管理员
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/addAdmin.action")
	ModelAndView addAdmin() {
		ModelAndView mvc =  new ModelAndView("AddAdmin");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/showAdmin.action")
	ModelAndView addAdmin(@RequestParam Admin admin) {
		
		ModelAndView mvc = null;
		admin = adminService.saveAdmin(admin);
		if (admin != null) {
			mvc = new ModelAndView("redirect:AddAdminResult");
		} else {
			mvc = new ModelAndView("redirect:AddAdminResult2");
		}
		return mvc;
	}
	/**
	 * 商家管理登录
	 * 
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/adminLogin.action")
	ModelAndView adminLogin(@RequestParam String adminName, String adminPwd) {

		ModelAndView mvc = new ModelAndView("AdminLogin");
		if (adminService.login(adminName, adminPwd)) {
			mvc = new ModelAndView("Admin");
		} else {
			mvc = new ModelAndView("AdminLogin");
		}
		return mvc;

	}

}
