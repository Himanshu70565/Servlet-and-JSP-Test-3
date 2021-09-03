package com.traineeapp.model.service;

import java.util.List;

import com.traineeapp.web.entity.Trainee;

public interface TraineeService {
	public List<Trainee> getAllTrainees();
	public Trainee addTrainee(Trainee trainee);
}
