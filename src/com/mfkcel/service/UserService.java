package com.mfkcel.service;

import java.util.List;

import com.mfkcel.model.User;

public interface UserService {
	public User login(User user);
	public List<User> getUsersByRoleName(String roleName);
}
