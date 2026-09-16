package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.AiScannerBean;
import com.sunilos.p4.model.AiScannerModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/AiScannerCtl")
public class AiScannerCtl extends BaseCtl<AiScannerBean, AiScannerModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("aiscannerName"))) {
			request.setAttribute("aiscannerName", PropertyReader.getValue("error.require", "AiScannerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getValue("error.require", "Type"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}
		return pass;
	}

	@Override
	protected AiScannerBean populateBean(HttpServletRequest request) {

		AiScannerBean bean = new AiScannerBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setAiscannerName(DataUtility.getString(request.getParameter("aiscannerName")));
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.AISCANNER_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.AISCANNER_VIEW;
	}

	@Override
	protected AiScannerModel getModel() {
		return new AiScannerModel();
	}

}
