package com.canguang.controller;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.canguang.model.Customer;
import com.canguang.service.ICaptchaService;
import com.canguang.service.ICustomerService;
import com.canguang.service.IMessageService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService customerservice;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private ICaptchaService captchaService;

	@RequestMapping(method = RequestMethod.GET, value = "/registerInput.action")
	ModelAndView registerInput(
			@RequestParam("merchantCode") String merchantCode,
			@RequestParam("storeCode") String storeCode) {

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("merchantCode", merchantCode);
		mv.addObject("storeCode", storeCode);
		return mv;
	}

	/**
	 * 保存註冊用戶
	 * 
	 * @param customerName
	 *            用户名
	 * @param phoneNumber
	 *            电话号码
	 * @param customerPwd
	 *            密码
	 * @param merchantCode
	 *            商家编码
	 * @param storeCode
	 *            门店编码
	 * @param phoneCode
	 *            手机验证码
	 * @param captcha
	 *            验证码
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/register.action")
	ModelAndView register(@RequestParam("customerName") String customerName,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("customerPwd") String customerPwd,
			@RequestParam("merchantCode") String merchantCode,
			@RequestParam("storeCode") String storeCode,
			@RequestParam(value = "phoneCode") String phoneCode,
			@RequestParam(value = "captcha") String captcha) {

		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setPhoneNumber(phoneNumber);
		customer.setCustomerPwd(customerPwd);

		boolean success = customerservice.saveCustomer(customer, merchantCode);
		ModelAndView mv = null;
		if (success) {
			mv = new ModelAndView("registerResult");
		} else {
			mv = new ModelAndView("register");
		}
		return mv;
	}

	/**
	 * 发送手机验证码
	 * 
	 * @param phoneNumber
	 * @param username
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sendPhoneVerifyCode.action")
	@ResponseBody
	boolean sendPhoneVerifyCode(
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam(value = "username", required = false) String username,
			HttpSession session) {
		/*
		 * 生成验证码
		 */
		String verifyCode = messageService.generateAndSendVerifyCode(username,
				phoneNumber);
		/*
		 * 验证码发送成功
		 */
		if (verifyCode != null) {

			/*
			 * 把验证码放到Session中 key: 手机号码 value：验证码
			 */
			session.setAttribute(phoneNumber, verifyCode);
			return true;
		}
		/*
		 * 验证码发送失败
		 */
		return false;
	}

	/**
	 * 获取验证码
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "getCaptcha.action")
	void getCaptcha(HttpSession session, HttpServletResponse response) {

		ByteArrayOutputStream captchaStream = captchaService.getCaptchaStream(
				session.getId(), Locale.getDefault());

		writeResponse(captchaService.getImageMediaType(), captchaStream,
				response);
	}

	/**
	 * 校验手机验证码（前台异步方式）
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "validatePhoneVerifyCode.action")
	@ResponseBody
	boolean validatePhoneVerifyCode(
			@RequestParam("phoneCode") String phoneVerifyCode) {
		return true;
	}

	/**
	 * 校验图形验证码（前台异步方式）
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "validateCaptcha.action")
	@ResponseBody
	boolean validateImageVerifyCode(
			@RequestParam("captcha") String captchaCode, HttpSession session) {
		if (StringUtils.isNotBlank(captchaCode) && captchaCode.length() == 4) {
			return captchaService.validateResponseForID(session.getId(),
					captchaCode);
		} else {
			return false;
		}
	}

	private void writeResponse(MediaType contentType,
			ByteArrayOutputStream captchaStream, HttpServletResponse response) {
		try {
			response.setContentType(contentType.toString());
			ServletOutputStream output = response.getOutputStream();
			output.write(captchaStream.toByteArray());
			output.flush();
			output.close();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}
}
