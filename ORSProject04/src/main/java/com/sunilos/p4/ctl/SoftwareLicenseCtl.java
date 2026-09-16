package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.PgHostelBean;
import com.sunilos.p4.bean.SoftwareLicenseBean;
import com.sunilos.p4.model.SoftwareLicenseModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SoftwareLicenseCtl")
public class SoftwareLicenseCtl extends BaseCtl<SoftwareLicenseBean, SoftwareLicenseModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("softwareName"))) {
			request.setAttribute("softwareName", PropertyReader.getValue("error.require", "SoftwareName"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("licenseKey"))) {
			request.setAttribute("licenseKey", PropertyReader.getValue("error.require", "LicenseKey"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("expiryDate"))) {
			request.setAttribute("expiryDate", PropertyReader.getValue("error.require", "ExpiryDate"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("vendore"))) {
			request.setAttribute("vendore", PropertyReader.getValue("error.require", "Vendore"));

			pass = false;
		}
		return pass;
	}

	@Override
	protected SoftwareLicenseBean populateBean(HttpServletRequest request) {
		
		SoftwareLicenseBean bean = new SoftwareLicenseBean();
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setSoftwareName(DataUtility.getString(request.getParameter("softwareName")));
		bean.setLicenseKey(DataUtility.getString(request.getParameter("licenseKey")));
		bean.setExpiryDate(DataUtility.getDate(request.getParameter("expiryDate")));
		bean.setVendore(DataUtility.getString(request.getParameter("vendore")));
		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.SOFTWARELICENSE_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.SOFTWARELICENSE_VIEW;
	}

	@Override
	protected SoftwareLicenseModel getModel() {
		// TODO Auto-generated method stub
		return new SoftwareLicenseModel();
	}

}
