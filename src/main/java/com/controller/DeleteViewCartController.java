package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.BodyTag;

import dao.UserDao;
import dao.ViewCartDao;


//DeleteController?Cartid=<%=cart.getcartid()%>
@WebServlet("/DeleteViewCartController")
public class DeleteViewCartController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartid = Integer.parseInt(request.getParameter("cartid"));
		ViewCartDao ViewCartDao = new ViewCartDao();
		boolean flag =ViewCartDao.deleteViewCart(cartid);
		if(flag) {
			request.setAttribute("message", "Deleted User Successfully");
		}else {
			request.setAttribute("message", "Some error Occured in Dao");
		}
		request.getRequestDispatcher("ViewCartController").forward(request, response);	
	}
}