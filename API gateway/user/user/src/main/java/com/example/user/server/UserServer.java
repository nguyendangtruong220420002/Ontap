package com.example.user.server;

import java.util.List;

import com.example.user.entity.User;

public interface UserServer {
	public List<User> findAllUser();

	public void addUser(User user);
}
