package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDao;


@WebServlet("/Logincontroller")
public class LoginController extends HttpServlet{


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email, password);
		
		RequestDispatcher rd = null;
		if(user == null) {
			request.setAttribute("errormsg", "Invalid credentials:");
			rd = request.getRequestDispatcher("Login.jsp");
			
		}else  {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			
			System.out.println(user.getUsertype());
			if(user.getUsertype().equals("customer")){
				rd = request.getRequestDispatcher("Home.jsp");
				
			}else if(user.getUsertype().equalsIgnoreCase("Admin")) {
				System.out.println("Admin");
				
				
				
				rd = request.getRequestDispatcher("Dashboard.jsp");
				
				
			}else {
				rd = request.getRequestDispatcher("404.jsp");
			}
			
			
			
		}
		rd.forward(request, response);
	}
}