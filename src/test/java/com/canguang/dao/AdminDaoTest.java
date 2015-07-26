package com.canguang.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.canguang.model.Admin;

@ContextConfiguration(locations = "classpath:config.xml")
public class AdminDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private IAdminDao adminDao;

	@Test
	public void testSave() {
		Admin admin = new Admin();
		admin.setAdminName("hello");
		admin.setAdminPwd("world");
		admin.setCreationTime(new Date());
		adminDao.save(admin);
	}
}
