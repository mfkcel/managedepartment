package com.mfkcel.service;

import java.util.List;

import com.mfkcel.model.User;

public interface UserService {
	public User login(User user);
	public List<User> getUsersByRoleName(String roleName);
	public List<User> getUsers();
	public User getUserById(String id);
	public boolean deleteById(String id);
	public boolean add(User user);
	public boolean update(User user);
}
