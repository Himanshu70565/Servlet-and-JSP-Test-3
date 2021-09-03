package com.traineeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.traineeapp.model.dao.factory.ConnectionFactory;
import com.traineeapp.web.entity.User;
import com.traineeapp.web.exception.DataAccessException;
import com.traineeapp.web.exception.UserNotFoundException;

public class UserDaoImpl implements UserDao{

	private Connection connection;
	
	public UserDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}
	
	@Override
	public User getUser(String username, String password) {
		User user = null;
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("select * from user_table where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
			} else {
				throw new UserNotFoundException("user with username " + username + " is not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		System.out.println(user);
		return user;
	}

}
