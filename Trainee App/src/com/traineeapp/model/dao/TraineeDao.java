package com.traineeapp.model.dao;

import java.util.*;

import com.traineeapp.web.entity.Trainee;

public interface TraineeDao {
	public List<Trainee> getAllTrainees();
	public Trainee addTrainee(Trainee trainee);
}
