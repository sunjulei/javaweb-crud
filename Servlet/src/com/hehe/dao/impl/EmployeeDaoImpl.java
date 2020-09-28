package com.hehe.dao.impl;

import com.hehe.bean.Employee;
import com.hehe.dao.EmployeeDao;
import com.hehe.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) {
        String emp_id = request.getParameter("empId");
        String emp_name = request.getParameter("empName");
        String emp_gender = request.getParameter("empGender");
        String emp_email = request.getParameter("empEmail");
        String dept = request.getParameter("dept");
        if (emp_id != null && emp_name != null && emp_gender != null && emp_email != null && dept != null) {
            Connection conn = DBUtils.open();
            String sql = "insert into tbl_emp(emp_name,emp_gender,emp_email,dept) values(?,?,?,?);";

            try {
                PreparedStatement prtmt = conn.prepareStatement(sql);
                prtmt.setString(1, emp_name);
                prtmt.setString(2, emp_gender);
                prtmt.setString(3, emp_email);
                prtmt.setString(4, dept);
                int resInt = prtmt.executeUpdate();
                request.setAttribute("resInt", resInt);
                request.getRequestDispatcher("/findAllServlet").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtils.close();
            }
        }
    }

    @Override
    public void findOne(HttpServletRequest request) {
        String id = request.getParameter("empId");// 获得前端传来的id;
        Map<String, Employee> map = new HashMap<>();
        Employee employee = new Employee();
        // 获得数据库连接
        Connection conn = DBUtils.open();
        String sql = "select * from tbl_emp where emp_id = ?";
        try {
            PreparedStatement prtmt = conn.prepareStatement(sql);
            prtmt.setString(1, id); // 设置?的值
            ResultSet rs = prtmt.executeQuery(); /// 执行sql
            while (rs.next()) {
                employee.setEmpId(rs.getInt("emp_id"));
                employee.setEmpName(rs.getString("emp_name"));
                employee.setEmpGender(rs.getString("emp_gender"));
                employee.setEmpEmail(rs.getString("emp_email"));
                employee.setDept(rs.getString("dept"));
                map.put("employee", employee);
            }
            request.setAttribute("employee", employee);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close();
        }
    }

    @Override
    public void findAll(HttpServletRequest request, HttpServletResponse response){
        List<Employee> employeeList = new ArrayList<Employee>(); // 创建一个list集合,用于装user集合
        Connection conn = DBUtils.open(); // 打开数据库连接
        String sql = " select * from tbl_emp order  by emp_id desc;";

        try {
            PreparedStatement prtmt = conn.prepareStatement(sql);
            ResultSet rs = prtmt.executeQuery();

            while (rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String emp_name = rs.getString("emp_name");
                String emp_gender = rs.getString("emp_gender");
                String emp_email = rs.getString("emp_email");
                String dept = rs.getString("dept");
                Employee employee = new Employee(); /// 实例化user
                employee.setEmpId(emp_id);
                employee.setEmpName(emp_name);
                employee.setEmpGender(emp_gender);
                employee.setEmpEmail(emp_email);
                employee.setDept(dept);
                employeeList.add(employee);
            }
            request.setAttribute("employeeList", employeeList);
            try {
                request.getRequestDispatcher("/user_list.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close();
        }
    }

    @Override
    public void del(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("empId"); // 传入id;
        if (id != null) {
            Connection conn = DBUtils.open();// 获得数据连接
            String sql = "delete from tbl_emp where emp_id = ?";
            try {
                PreparedStatement prtmt = conn.prepareStatement(sql); // 预编译

                prtmt.setString(1, id); // 给id赋值
                int resInt = prtmt.executeUpdate(); // 执行sql返回影响行数;
                request.setAttribute("resInt", resInt);
                try {
                    request.getRequestDispatcher("/findAllServlet").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtils.close();
            }

        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response){
        String emp_id = request.getParameter("empId");
        String emp_name = request.getParameter("empName");
        String emp_gender = request.getParameter("empGender");
        String emp_email = request.getParameter("empEmail");
        String dept = request.getParameter("dept");

        if (emp_id != null && emp_name != null && emp_gender != null && emp_email != null && dept != null) {

            Connection conn = DBUtils.open();
            String sql = "update tbl_emp set emp_name=?,emp_gender=?,emp_email=?,dept=? where emp_id=?";

            try {
                PreparedStatement prtmt = conn.prepareStatement(sql);

                prtmt.setString(1, emp_name);
                prtmt.setString(2, emp_gender);
                prtmt.setString(3, emp_email);
                prtmt.setString(4, dept);
                prtmt.setString(5, emp_id);

                int resInt = prtmt.executeUpdate(); // 执行
                request.setAttribute("resInt", resInt); // 返回影响的行数
                try {
                    request.getRequestDispatcher("/findAllServlet").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtils.close();
            }
        }
    }
}
