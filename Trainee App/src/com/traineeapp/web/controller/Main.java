package com.traineeapp.web.controller;

import com.traineeapp.model.dao.UserDao;
import com.traineeapp.model.dao.UserDaoImpl;
import com.traineeapp.web.entity.User;

public class Main {
	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
		User user = userDao.getUser("h", "root");
//		System.out.println(user);
		System.out.println("Hello there");
	}
}
