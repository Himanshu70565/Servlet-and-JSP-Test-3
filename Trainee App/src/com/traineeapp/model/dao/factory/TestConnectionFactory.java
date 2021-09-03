package com.traineeapp.model.dao.factory;

import java.sql.Connection;

public class TestConnectionFactory {
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println(connection);
	}
}
