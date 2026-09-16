package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.HospitalBean;
import com.sunilos.p4.model.HospitalModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HospitalCtl")
public class HospitalCtl extends BaseCtl<HospitalBean, HospitalModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("patientName"))) {
			request.setAttribute("patientName", PropertyReader.getValue("error.require", "PatientName"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("disease"))) {
			request.setAttribute("disease", PropertyReader.getValue("error.require", "Disease"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("doctorName"))) {
			request.setAttribute("doctorName", PropertyReader.getValue("error.require", "DoctorName"));
			pass = false;
		}
		

		if(DataValidator.isNull(request.getParameter("admissionDate"))) {
			request.setAttribute("admissionDate", PropertyReader.getValue("error.require", "AdmissionDate"));
			pass = false;
		
		}
		return pass;

	}

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
		// TODO Auto-generated method stub
		return ORSView.HOSPITAL_VIEW;
	}

	@Override
	protected String getView(String op) {
		// TODO Auto-generated method stub
		return ORSView.HOSPITAL_VIEW;
	}

	@Override
	protected HospitalModel getModel() {
		// TODO Auto-generated method stub
		return new HospitalModel();
	}

}
