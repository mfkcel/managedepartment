package com.mfkcel.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mfkcel.daoimpl.UserDaoImpl;
import com.mfkcel.model.User;

public class UserDaoImplTest2 {

	
	private UserDaoImpl userDao;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = ac.getBean("userDao", UserDaoImpl.class);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	void testLogin5() {
		User user = new User("mfkcel", "123");
		User rUser = userDao.login5(user);
		User rUser2 = userDao.login6(user);
		System.out.println("1:" +rUser);
		System.out.println(rUser2);
	}

}
