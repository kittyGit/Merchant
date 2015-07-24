package com.canguang.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Admin;
import com.canguang.model.Customer;
import com.canguang.service.IAdminService;
import com.canguang.service.ICustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/loginInput.action")
	ModelAndView loginInput() {
		ModelAndView mvc = new ModelAndView("login");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.action")
	ModelAndView login(@RequestParam("adminName") String adminName, @RequestParam("adminPwd") String adminPwd,
			HttpSession session) {

		ModelAndView mvc = null;

		Admin admin = adminService.login(adminName, adminPwd);
		if (admin != null) {
			if (admin.getMerchant() != null) {
				mvc = new ModelAndView("merchantAdmin");
			} else {
				mvc = new ModelAndView("canGuangAdmin");
			}
			session.setAttribute("admin", admin);
		} else {
			mvc = new ModelAndView("login");
		}

		return mvc;
	}

	/**
	 * 验证用户是否有消费记录（首页）
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/verify.action")
	ModelAndView verify() {

		ModelAndView mvc = new ModelAndView("canGuangAdmin");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showVerifyCustomer.action")
	ModelAndView exchange(@RequestParam("phoneNumber") String phoneNumber, HttpSession session) {
		ModelAndView mvc = new ModelAndView("canGuangAdmin");
		List<Customer> customerExchanges = customerService.findByPhoneNumber(phoneNumber, session);
		mvc.addObject("customerExchanges", customerExchanges);
		return mvc;
	}

	/**
	 * 查询用户交易记录(交易页面)
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/customerExchange.action")
	ModelAndView exchangeCustomer() {

		ModelAndView mvc = new ModelAndView("exchange");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showExchange.action")
	ModelAndView customersExchange(@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("registerAddress") String registerAddress,
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("registerTimeStart") Date registerTimeStart,
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("registerTimeEnd") Date registerTimeEnd,
			HttpSession session) {

		ModelAndView mvc = new ModelAndView("exchange");

		List<Customer> customerExchanges = customerService.findByNumerAndAddressAndTime(phoneNumber, registerAddress,
				registerTimeStart, registerTimeEnd, session);

		mvc.addObject("customerExchanges", customerExchanges);

		return mvc;
	}

	/**
	 * 查寻会员（会员页面）
	 * 
	 * @return
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/vipCustomer.action")
	ModelAndView vipCustomer() {

		ModelAndView mvc = new ModelAndView("vip");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showVip.action")
	ModelAndView showVip(@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("registerAddress") String registerAddress,
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("registerTimeStart") Date registerTimeStart,
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("registerTimeEnd") Date registerTimeEnd,
			HttpSession session) {

		ModelAndView mvc = new ModelAndView("vip");
		List<Customer> customerVips = customerService.findByNumerAndAddressAndTime(phoneNumber, registerAddress,
				registerTimeStart, registerTimeEnd, session);
		mvc.addObject("customerVips", customerVips);
		return mvc;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/editPwdInput.action")
	ModelAndView editPwdInput(@RequestParam("merchantId") Integer merchantId) {

		ModelAndView mvc = new ModelAndView("editPwd");
		mvc.addObject("merchantId", merchantId);
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editPwd.action")
	ModelAndView editPwd(@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd,
			@RequestParam("confirmPwd") String confirmPwd, @RequestParam("merchantId") Integer merchantId) {

		ModelAndView mvc = null;
		if (adminService.updatePassword(oldPwd, newPwd, confirmPwd, merchantId)) {
			mvc = new ModelAndView("editPwd");
		}

		return mvc;
	}
}
