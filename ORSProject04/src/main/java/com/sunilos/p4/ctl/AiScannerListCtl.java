package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.AiScannerBean;
import com.sunilos.p4.model.AiScannerModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/AiScannerListCtl")
public class AiScannerListCtl extends BaseListCtl<AiScannerBean, AiScannerModel> {

	@Override
	protected AiScannerBean populateBean(HttpServletRequest request) {

		AiScannerBean bean = new AiScannerBean();

		bean.setAiscannerName(
				DataUtility.getStringData(
						request.getParameter("aiscannerName")));

		bean.setDescription(
				DataUtility.getStringData(
						request.getParameter("description")));

		bean.setType(
				DataUtility.getStringData(
						request.getParameter("type")));

		bean.setStatus(
				DataUtility.getStringData(
						request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {

		return ORSView.AISCANNER_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {

		return ORSView.AISCANNER_LIST_VIEW;
	}

	@Override
	protected AiScannerModel getModel() {

		return new AiScannerModel();
	}
}