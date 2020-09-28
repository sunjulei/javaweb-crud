package com.hehe.service.impl;

import com.hehe.bean.Employee;
import com.hehe.dao.EmployeeDao;
import com.hehe.dao.impl.EmployeeDaoImpl;
import com.hehe.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeServiceImpl implements EmployeeService {

   public static EmployeeDao employeeDao=new EmployeeDaoImpl();;

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) {
        employeeDao.add(request,response);
    }

    @Override
    public void findOne(HttpServletRequest request) {
        employeeDao.findOne(request);
    }

    @Override
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        employeeDao.findAll(request,response);
    }

    @Override
    public void del(HttpServletRequest request, HttpServletResponse response) {
        employeeDao.del(request,response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        employeeDao.update(request,response);
    }
}
