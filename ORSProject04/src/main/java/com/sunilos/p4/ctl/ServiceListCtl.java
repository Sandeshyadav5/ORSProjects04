package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ServiceBean;
import com.sunilos.p4.model.ServiceModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ServiceListCtl")
public class ServiceListCtl extends BaseListCtl<ServiceBean, ServiceModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("serviceName"))) {
			request.setAttribute("serviceName",
					PropertyReader.getValue("error.require", "ServiceName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price",
					PropertyReader.getValue("error.require", "Price"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description",
					PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("category"))) {
			request.setAttribute("category",
					PropertyReader.getValue("error.require", "Category"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected String getView() {
		return ORSView.SERVICE_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.SERVICE_LIST_VIEW;
	}

	@Override
	protected ServiceModel getModel() {
		return new ServiceModel();
	}
}