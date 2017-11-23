package com.mfkcel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mfkcel.dao.UserDao;
import com.mfkcel.model.User;
import com.mfkcel.service.UserService;

@Repository("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
