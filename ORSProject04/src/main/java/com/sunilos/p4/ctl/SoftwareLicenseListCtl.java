package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.SoftwareLicenseBean;
import com.sunilos.p4.model.SoftwareLicenseModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SoftwareLicenseListCtl")
public class SoftwareLicenseListCtl extends BaseListCtl<SoftwareLicenseBean, SoftwareLicenseModel> {

	@Override
	protected SoftwareLicenseBean populateBean(HttpServletRequest request) {

		SoftwareLicenseBean bean = new SoftwareLicenseBean();

		bean.setSoftwareName(DataUtility.getString(request.getParameter("softwareName")));
		bean.setLicenseKey(DataUtility.getString(request.getParameter("licenseKey")));
		bean.setExpiryDate(DataUtility.getDate(request.getParameter("expiryDate")));
		bean.setVendore(DataUtility.getString(request.getParameter("vendore")));
		populateDTO(bean, request);

		return bean;

	}

	@Override
	protected String getView() {
		return ORSView.SOFTWARELICENSE_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.SOFTWARELICENSE_LIST_VIEW;
	}

	@Override
	protected SoftwareLicenseModel getModel() {
		return new SoftwareLicenseModel();
	}

}
