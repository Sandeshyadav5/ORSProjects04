package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.model.EmployeeModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/EmployeeListCtl")
public class EmployeeListCtl extends BaseListCtl<EmployeeBean, EmployeeModel>{
	
	@Override
	protected EmployeeBean populateBean(HttpServletRequest request) {
		
		EmployeeBean bean = new EmployeeBean();
		bean.setEmployeeName(DataUtility.getStringData(request.getParameter("employeeName")));
		bean.setCompany(DataUtility.getStringData(request.getParameter("company")));
		bean.setSalary(DataUtility.getStringData(request.getParameter("salary")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		populateDTO(bean, request);
		
		return bean;
		
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.EMPLOYEE_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.EMPLOYEE_LIST_VIEW;
	}

	@Override
	protected EmployeeModel getModel() {
		// TODO Auto-generated method stub
		return new EmployeeModel();
	}

}
