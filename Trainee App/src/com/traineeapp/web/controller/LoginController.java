package com.traineeapp.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.traineeapp.model.service.UserService;
import com.traineeapp.model.service.UserServiceImplJdbc;
import com.traineeapp.web.entity.User;
import com.traineeapp.web.exception.UserNotFoundException;



@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService=new UserServiceImplJdbc();
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username+" "+password);
		
		try {
			User user=userService.getUser(username, password);	
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("TraineeController.do?action=showAllTrainee");
		} catch (UserNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
			response.sendRedirect("login.jsp?message=Incorrect username and paasword");
		}
	}

}
