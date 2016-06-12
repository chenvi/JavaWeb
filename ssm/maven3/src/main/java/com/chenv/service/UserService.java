package com.chenv.service;

import java.util.List;

import com.chenv.pojo.User;

public interface UserService {
	public User getUserById(int userId);
	public void insertUser(List<User> users);
}