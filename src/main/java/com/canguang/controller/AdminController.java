package com.canguang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import com.canguang.service.IAdminService;
=======
import com.canguang.dao.IMerchantDao;
import com.canguang.model.Admin;
import com.canguang.model.Merchant;
import com.canguang.service.IAdminService;
import com.canguang.service.IMerchantService;
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

<<<<<<< HEAD
	@RequestMapping(method = RequestMethod.POST, value = "/login.action")
	ModelAndView login(@RequestParam String userName, String pwd) {

		ModelAndView mvc = null;
		mvc = new ModelAndView("redirect:login");
		if (adminService.login(userName, pwd)) {
			mvc = new ModelAndView("redirect:login");
            
		} else {
			mvc = new ModelAndView("index");
		}
=======
	@RequestMapping(method = RequestMethod.GET, value = "/loginInput.action")
	ModelAndView loginInput() {
		ModelAndView mvc = new ModelAndView("login");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.action")
	ModelAndView merchantLogin(@RequestParam("adminName") String adminName,
			@RequestParam("adminName") String adminPwd) {

		Admin admin=null;
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);

		ModelAndView mvc = null;
//		if (adminService.merchanLogin(admin, merchant)) {
//			mvc = new ModelAndView("MerchantAdmin");
//		} else if (adminService.superLogin(admin)) {
//			mvc = new ModelAndView("canguangAdmin");
//		}
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
		return mvc;
	}

}
