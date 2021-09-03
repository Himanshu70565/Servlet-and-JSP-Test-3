package com.traineeapp.model.service;

import com.traineeapp.model.dao.UserDao;
import com.traineeapp.model.dao.UserDaoImpl;
import com.traineeapp.web.entity.User;

public class UserServiceImplJdbc implements UserService{

	private UserDao userDao;
	
	public UserServiceImplJdbc() {
		userDao=new UserDaoImpl();
	}
	
	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}
}
