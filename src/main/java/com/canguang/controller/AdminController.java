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

		Admin admin = adminService.login(adminName, adminPwd);

		ModelAndView mvc = null;
		if (admin != null) {
			mvc = new ModelAndView("merchantAdmin");
			session.setAttribute("admin", admin);
		} else {
			mvc = new ModelAndView("login");
		}

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
			@RequestParam("pageNo") int pageNo, @RequestParam("perPageSize") int perPageSize, HttpSession session) {

		ModelAndView mvc = new ModelAndView("exchange");

		Admin admin = (Admin) session.getAttribute("admin");
		List<Customer> customerExchanges = customerService.findByNumerAndAddressAndTime(phoneNumber, registerAddress,
				registerTimeStart, registerTimeEnd, admin.getMerchant(), pageNo, perPageSize);

		mvc.addObject("customerExchanges", customerExchanges);
		mvc.addObject("pageNo", pageNo);
		int pageSize = customerService.countPageSize(phoneNumber, registerAddress, registerTimeStart, registerTimeEnd,
				admin.getMerchant(), perPageSize);
		mvc.addObject("pageSize", pageSize);

		return mvc;
	}

	/**
	 * 查询会员（会员页面）
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
			@RequestParam("pageNo") int pageNo, @RequestParam("perPageSize") int perPageSize, HttpSession session) {

		ModelAndView mvc = new ModelAndView("vip");
		Admin admin = (Admin) session.getAttribute("admin");

		List<Customer> customerVips = customerService.findByNumerAndAddressAndTime(phoneNumber, registerAddress,
				registerTimeStart, registerTimeEnd, admin.getMerchant(), pageNo, perPageSize);

		int pageSize = customerService.countPageSize(phoneNumber, registerAddress, registerTimeStart, registerTimeEnd,
				admin.getMerchant(), perPageSize);

		mvc.addObject("pageNo", pageNo);
		mvc.addObject("pageSize", pageSize);
		mvc.addObject("customerVips", customerVips);
		return mvc;
	}

	/**
	 * 修改密码（显示界面）
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/editPwdInput.action")
	ModelAndView editPwdInput() {
		ModelAndView mvc = new ModelAndView("editPwd");
		return mvc;
	}

	/**
	 * 修改密码（提交）
	 * 
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/editPwd.action")
	ModelAndView editPwd(@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd,
			@RequestParam("confirmPwd") String confirmPwd, HttpSession session) {

		/*
		 * 失败返回修改页面
		 */
		ModelAndView mvc = new ModelAndView("editPwd");

		Admin admin = (Admin) session.getAttribute("admin");
		if (newPwd.equals(confirmPwd)) {
			if (adminService.updatePassword(newPwd, admin)) {
				mvc = new ModelAndView("editResult");
			}
		}

		return mvc;
	}

	/**
	 * 退出，回到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/loginOut.action")
	ModelAndView loginOut() {
		ModelAndView mvc = new ModelAndView("login");
		return mvc;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/logOut.action")
	ModelAndView logOut(HttpSession session) {

		ModelAndView mvc = new ModelAndView("login");
		session.removeAttribute((String) session.getAttribute("admin"));
		return mvc;
	}
}
