package com.hehe.service;

import com.hehe.bean.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface EmployeeService {

    void add(HttpServletRequest request, HttpServletResponse response);

    void findOne(HttpServletRequest request);

    void findAll(HttpServletRequest request, HttpServletResponse response);

    void del(HttpServletRequest request, HttpServletResponse response);

    void update(HttpServletRequest request, HttpServletResponse response);

}
