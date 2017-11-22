package com.mfkcel.test;

import java.util.List;
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
	
	@Test
	void testLogin2() {
		User user = new User("mfkcel", "123");
		User rUser = userDao.login2(user);
		System.out.println(rUser);
	}


	@Test
	void testLogin3() {
		User user = new User("mfkcel", "123");
		List<User> users = userDao.login3(user);
		for(User user2: users) {
			System.out.println(user2);
		}
	}
	
	@Test
	void testLogin5() {
		User user = new User("mfkcel", "123");
		User rUser = userDao.login5(user);
		System.out.println(rUser);
	}
}
