package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.HospitalBean;
import com.sunilos.p4.model.HospitalModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/HospitalReportCtl")
public class HospitalReportCtl  extends BaseReportCtl<HospitalBean>{

	@Override
	public List<HospitalBean> getList() {
		HospitalModel model = new HospitalModel();
		List<HospitalBean> hospitals = model.list();
		
		return hospitals;
	}
	
	
	@Override
	public String getView() {
		return ORSView.HOSPITAL_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		// TODO Auto-generated method stub
		return "HOSPITAL_LIST_COMPILED_REPORT";
	}


}
