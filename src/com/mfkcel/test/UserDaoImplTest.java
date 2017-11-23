package com.mfkcel.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mfkcel.daoimpl.UserDaoImpl;
import com.mfkcel.model.User;

class UserDaoImplTest {
	
	private UserDaoImpl userDao;
	@BeforeEach
	void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = ac.getBean("userDao", UserDaoImpl.class);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLogin() {
		User user = new User("mfkcel", "123");
		User tUser = userDao.login(user);
		userDao.login(tUser);
	}
	
	
}
