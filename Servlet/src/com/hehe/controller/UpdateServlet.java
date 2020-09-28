package com.hehe.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hehe.service.EmployeeService;
import com.hehe.service.impl.EmployeeServiceImpl;
import com.hehe.utils.DBUtils;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	EmployeeService employeeService=new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employeeService.update(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}

}
