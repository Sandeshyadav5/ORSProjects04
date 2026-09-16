package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.model.EmployeeModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/EmployeeReportCtl")
public class EmployeeReportCtl extends BaseReportCtl<EmployeeBean>{

	@Override
	public List<EmployeeBean> getList() {
		EmployeeModel model = new EmployeeModel();
		List<EmployeeBean> employees = model.list();
		return employees;
	}
	
	
	
	@Override
	public String getView() {
		return ORSView.EMPLOYEE_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		// TODO Auto-generated method stub
		return "EMPLOYEE_LIST_COMPLIE_REPORT";
	}

	

}
