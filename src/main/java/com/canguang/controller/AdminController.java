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

	@RequestMapping(method = RequestMethod.POST, value = "/login.action")
	ModelAndView login(@RequestParam String userName, String pwd) {

		ModelAndView mvc = null;
		mvc = new ModelAndView("redirect:login");
		if (adminService.login(userName, pwd)) {
			mvc = new ModelAndView("redirect:login");
            
		} else {
			mvc = new ModelAndView("index");
		}
		return mvc;
	}

}
