package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.QrScannerCodeBean;
import com.sunilos.p4.model.QrScannerCodeModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/QrScannerCodeListCtl")
public class QrScannerCodeListCtl extends BaseListCtl<QrScannerCodeBean, QrScannerCodeModel>{
	
	@Override
	protected QrScannerCodeBean populateBean(HttpServletRequest request) {
		QrScannerCodeBean bean = new QrScannerCodeBean();
		bean.setQrCode(DataUtility.getString(request.getParameter("qrcode")));
		bean.setScannedBy(DataUtility.getString(request.getParameter("scannedby")));
		bean.setScanTime(DataUtility.getDate(request.getParameter("scantime")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);
		return bean;

	}


	@Override
	protected String getView() {
		return ORSView.QRSCANNERCODE_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.QRSCANNERCODE_LIST_VIEW;
	}

	@Override
	protected QrScannerCodeModel getModel() {
		return new QrScannerCodeModel() {
		};
	}

}
