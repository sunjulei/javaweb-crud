package com.hehe.bean;

public class Employee {
	private Integer empId;
	private String empName;
	private String empGender;
	private String empEmail;
	private String dept;

	public Employee() {
	}

	public Employee(String empName, String empGender, String empEmail, String dept) {
		this.empName = empName;
		this.empGender = empGender;
		this.empEmail = empEmail;
		this.dept = dept;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
