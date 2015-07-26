package com.canguang.service;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

import org.springframework.http.MediaType;

public interface ICaptchaService {

	/**
	 * 生成验证码，返回ByteArrayOutputStream
	 * 
	 * @param captchaId
	 *            session id
	 * @param locale
	 *            locales for request
	 * @return an jpeg stream
	 */
	ByteArrayOutputStream getCaptchaStream(String captchaId, Locale locale);

	/**
	 * 校验验证码
	 * 
	 * @param id
	 *            session id
	 * @param response
	 *            text of response
	 * @return
	 */
	boolean validateResponseForID(String id, String response);

	MediaType getImageMediaType();
}
