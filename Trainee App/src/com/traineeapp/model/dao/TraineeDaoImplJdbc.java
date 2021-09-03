package com.traineeapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.traineeapp.model.dao.factory.ConnectionFactory;
import com.traineeapp.web.entity.Trainee;
import com.traineeapp.web.exception.DataAccessException;


public class TraineeDaoImplJdbc implements TraineeDao{

	private Connection connection;
	
	public TraineeDaoImplJdbc() {
		connection=ConnectionFactory.getConnection();
	}
	
	@Override
	public List<Trainee> getAllTrainees() {
		List<Trainee> list=new ArrayList<>();
		try {
			PreparedStatement pstmt=connection.prepareStatement("select * from trainee_table");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Trainee trainee=new Trainee(rs.getInt("trainee_id"), rs.getString("trainee_name"), rs.getString("branch"), rs.getDouble("percentage"));
				list.add(trainee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		try {
			String ADD_TRAINEE = "insert into trainee_table(trainee_name,branch,percentage) values(?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(ADD_TRAINEE,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, trainee.getTrainee_name());
			pstmt.setString(2, trainee.getBranch());
			pstmt.setDouble(3, trainee.getPercentage());
			
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate>0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				trainee.setTrainee_id(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DataAccessException(e.getLocalizedMessage());
		}
		return trainee;
	}
}
