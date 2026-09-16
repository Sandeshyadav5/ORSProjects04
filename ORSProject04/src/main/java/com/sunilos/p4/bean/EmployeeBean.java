package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmployeeBean extends BaseBean {

	private String employeeName;
	private String company;
	private String salary;
	private Date dob;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setEmployeeName(rs.getString("employeename"));
			this.setCompany(rs.getString("company"));
			this.setSalary(rs.getString("salary"));
			this.setDob(rs.getDate("dob"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return employeeName;
	}


	
	

}
