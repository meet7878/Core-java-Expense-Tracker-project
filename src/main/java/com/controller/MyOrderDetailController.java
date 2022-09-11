package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderDetailProductBean;
import dao.OrderDetailDao;


//order table
public class MyOrderDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderDetailDao Dao =  new OrderDetailDao();
		ArrayList<OrderDetailProductBean> details = Dao.getOrderDetails(orderId);
		request.setAttribute("details", details);
		request.getRequestDispatcher("MyOrdersDetail.jsp").forward(request, response);
		
		
		
	}



}
