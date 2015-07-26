package com.canguang.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:config.xml")
public class CaptchaServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ICaptchaService captchaService;

	@Test
	public void test() throws Exception {

		String captchaId = UUID.randomUUID().toString();
		ByteArrayOutputStream byteArrayStream = captchaService
				.getCaptchaStream(captchaId, Locale.getDefault());

		FileOutputStream fos = new FileOutputStream(
				"src/test/resources/generate/验证码.png");
		fos.write(byteArrayStream.toByteArray());
		fos.flush();
		fos.close();
	}
}
