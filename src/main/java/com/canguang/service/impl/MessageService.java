package com.canguang.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canguang.dto.message.Result;
import com.canguang.dto.message.VarsDto;
import com.canguang.service.IMessageService;
import com.canguang.service.message.IMessageSender;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private IMessageSender messageSender;

	/**
	 * 生成并發送驗證碼
	 */
	@Override
	public String generateAndSendVerifyCode(String username, String phoneNo) {

		// 生成验证码
		String verifyCode = RandomStringUtils.randomNumeric(5);

		VarsDto vars = new VarsDto();
		vars.setUsername(StringUtils.trimToEmpty(username));
		vars.setvCode(verifyCode);

		// 发送验证码
		Result result = messageSender.send(phoneNo, vars);

		if (result.getStatus() == Result.Status.SUCCESS) {
			return verifyCode;
		}

		// 发送失败
		return null;
	}
}
