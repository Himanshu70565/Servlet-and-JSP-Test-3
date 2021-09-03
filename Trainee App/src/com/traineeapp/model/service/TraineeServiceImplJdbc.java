package com.traineeapp.model.service;

import java.util.List;

import com.traineeapp.model.dao.TraineeDao;
import com.traineeapp.model.dao.TraineeDaoImplJdbc;
import com.traineeapp.web.entity.Trainee;

public class TraineeServiceImplJdbc implements TraineeService{

	private TraineeDao traineeDao;
	
	public TraineeServiceImplJdbc() {
		traineeDao=new TraineeDaoImplJdbc();
	}
	
	@Override
	public List<Trainee> getAllTrainees() {
		return traineeDao.getAllTrainees();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}

}
