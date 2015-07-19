package com.canguang.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@Ignore
@ContextConfiguration(locations = "classpath:config.xml")
public class MessageServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private IMessageService messageService;

	@Test
	public void testSendMessage() {
		messageService.generateAndSendVerifyCode("kitty", "13534085364");
	}
}
