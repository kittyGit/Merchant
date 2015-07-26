package com.canguang.service;

public interface IMessageService {

	/**
	 * 生成并发送手机验证码
	 * 
	 * @return
	 */
	String generateAndSendVerifyCode(String username, String phoneNo);
}
