package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.PetBean;
import com.sunilos.p4.model.PetModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/PetListCtl")
public class PetListCtl extends BaseListCtl<PetBean, PetModel>{
	
	@Override
	protected PetBean populateBean(HttpServletRequest request) {
		PetBean bean = new PetBean();
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
		return ORSView.PET_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		// TODO Auto-generated method stub
		return  ORSView.PET_LIST_VIEW;
	}

	@Override
	protected PetModel getModel() {
		// TODO Auto-generated method stub
		return new PetModel();
	}

}
