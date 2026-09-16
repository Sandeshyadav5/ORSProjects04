package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.HospitalBean;
import com.sunilos.p4.model.HospitalModel;
import com.sunilos.p4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HospitalListCtl")
public class HospitalListCtl extends BaseListCtl<HospitalBean, HospitalModel> {
	@Override
	protected HospitalBean populateBean(HttpServletRequest request) {
		HospitalBean bean = new HospitalBean();
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setPatientName(DataUtility.getString(request.getParameter("patientName")));
		bean.setDisease(DataUtility.getString(request.getParameter("disease")));
		bean.setDoctorName(DataUtility.getString(request.getParameter("doctorName")));
		bean.setAdmissionDate(DataUtility.getDate(request.getParameter("admissionDate")));
		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.HOSPITAL_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.HOSPITAL_LIST_VIEW;
	}

	@Override
	protected HospitalModel getModel() {
		return new HospitalModel();
	}

}
