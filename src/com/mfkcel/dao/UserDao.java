package com.mfkcel.dao;

import java.util.List;

import com.mfkcel.model.User;

public interface UserDao {
	public User login(User user);
	public List<User> getUsersByRoleName(String roleName);
}
