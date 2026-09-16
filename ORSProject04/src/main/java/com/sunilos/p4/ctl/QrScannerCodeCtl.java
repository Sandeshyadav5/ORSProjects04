package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.QrScannerCodeBean;
import com.sunilos.p4.model.QrScannerCodeModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/QrScannerCodeCtl")
public class QrScannerCodeCtl extends BaseCtl<QrScannerCodeBean, QrScannerCodeModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("qrcode"))) {
			request.setAttribute("qrcode", PropertyReader.getValue("error.require", "QrCode"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("scannedby"))) {
			request.setAttribute("scannedby", PropertyReader.getValue("error.require", "ScannedBy"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("scantime"))) {
			request.setAttribute("scantime", PropertyReader.getValue("error.require", "ScanTime"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;

		}

		return pass;
	}

	@Override
	protected QrScannerCodeBean populateBean(HttpServletRequest request) {
		QrScannerCodeBean bean = new QrScannerCodeBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setQrCode(DataUtility.getString(request.getParameter("qrcode")));
		bean.setScannedBy(DataUtility.getString(request.getParameter("scannedby")));
		bean.setScanTime(DataUtility.getDate(request.getParameter("scantime")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);
		return bean;

	}

	@Override
	protected String getView() {
		return ORSView.QRSCANNERCODE_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.QRSCANNERCODE_VIEW;
	}

	@Override
	protected QrScannerCodeModel getModel() {
		return new QrScannerCodeModel() {
		};
	}

}
