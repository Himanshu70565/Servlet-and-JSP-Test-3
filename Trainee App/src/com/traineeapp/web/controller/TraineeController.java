package com.traineeapp.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traineeapp.model.dao.TraineeDao;
import com.traineeapp.model.dao.TraineeDaoImplJdbc;
import com.traineeapp.model.service.TraineeService;
import com.traineeapp.model.service.TraineeServiceImplJdbc;
import com.traineeapp.web.entity.Trainee;


@WebServlet("/TraineeController.do")
public class TraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TraineeService traineeService=new TraineeServiceImplJdbc();
	
    public TraineeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trainee> trainees = traineeService.getAllTrainees();
		request.setAttribute("trainees", trainees);
		request.getRequestDispatcher("showAllTrainees.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		Double percentage=Double.parseDouble(request.getParameter("percentage"));
		Trainee trainee=new Trainee(name, branch, percentage);
		traineeService.addTrainee(trainee);
		response.sendRedirect("TraineeController.do");
	}

}
