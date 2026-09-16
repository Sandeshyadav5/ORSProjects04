package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.PetBean;
import com.sunilos.p4.model.PetModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/PetCtl")
public class PetCtl extends BaseCtl<PetBean, PetModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("petName"))) {
			request.setAttribute("petName", PropertyReader.getValue("error.require", "PetName"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("ownerName"))) {
			request.setAttribute("ownerName", PropertyReader.getValue("error.require", "OwnerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("breed"))) {
			request.setAttribute("breed", PropertyReader.getValue("error.require", "Breed"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("age"))) {
			request.setAttribute("age", PropertyReader.getValue("error.require", "Age"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("vaccinationstatus"))) {
			request.setAttribute("vaccinationstatus", PropertyReader.getValue("error.require", "VaccinationStatus"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected PetBean populateBean(HttpServletRequest request) {
		PetBean bean = new PetBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setPetName(DataUtility.getString(request.getParameter("petName")));
		bean.setOwnerName(DataUtility.getString(request.getParameter("ownerName")));
		bean.setBreed(DataUtility.getString(request.getParameter("breed")));
		bean.setAge(DataUtility.getInt(request.getParameter("age")));
		bean.setVaccinationStatus(DataUtility.getString(request.getParameter("vaccinationstatus")));

		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PET_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.PET_VIEW;
	}

	@Override
	protected PetModel getModel() {
		return new PetModel();
	}

}
