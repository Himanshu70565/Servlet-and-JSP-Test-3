package com.traineeapp.model.dao;

import com.traineeapp.web.entity.User;

public interface UserDao {
	public User getUser(String username,String password);
}
