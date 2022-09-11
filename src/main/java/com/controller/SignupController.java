package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		System.out.println(gender);
		
		boolean isError = false;
		
		if(firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError","Please Enter FirstName");
		}else {
			request.setAttribute("firstNameValue", firstName);
		}
		
		if(lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError","Please Enter lastName");
		}else {
			request.setAttribute("lastNameValue", lastName);
		}
		
		if(password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError","Please Enter Password");
		}else {
			request.setAttribute("passwordValue", password);
		}
		
		if(email == null || email.trim().length()==0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		}else {
			request.setAttribute("emailValue", email);
		}
		
		if(gender == null) {
			isError=true;
			request.setAttribute("genderError", "Please Select Gender");
		}else {
			request.setAttribute("genderValue" , gender);
		}
		RequestDispatcher rd = null;
		if(isError == true) {
			// Goback
			rd = request.getRequestDispatcher("Signup.jsp");
		}else {
			UserDao userDao= new UserDao();
			
			UserBean userBean = new UserBean();
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setUsertype("customer");
			
			userDao.insertUser(userBean);
			
			
			
			//userDao.insertUser(firstName, lastName, email, password, gender);
			//goahead
			request.setAttribute("msg","signup done..");
			rd = request.getRequestDispatcher("Login.jsp");
		}
		rd.forward(request, response);
		//set your data for accessing in text
//		request.setAttribute("firstName",firstName);
//		request.setAttribute("lastName",lastName);
//		request.setAttribute("email",email);
//		request.setAttribute("password",password);
//		request.setAttribute("gender",gender);
		
		
		//System.out.println("Hello From Controller..");
	}
}
