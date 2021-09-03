package com.traineeapp.model.service;

import com.traineeapp.web.entity.User;

public interface UserService {
	public User getUser(String username,String password);
}
