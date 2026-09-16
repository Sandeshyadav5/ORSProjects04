package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.PgHostelBean;
import com.sunilos.p4.model.PgHostelModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/PgHostelCtl")
public class PgHostelCtl extends BaseCtl<PgHostelBean, PgHostelModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("ownerName"))) {
			request.setAttribute("ownerName", PropertyReader.getValue("error.require", "OwnerName"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getValue("error.require", "Location"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("rent"))) {
			request.setAttribute("rent", PropertyReader.getValue("error.require", "Rent"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("roomType"))) {
			request.setAttribute("roomType", PropertyReader.getValue("error.require", "RoomType"));
			pass = false;
		}
		return pass;
	}

	@Override
	protected PgHostelBean populateBean(HttpServletRequest request) {
		PgHostelBean bean = new PgHostelBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setOwnerName(DataUtility.getStringData(request.getParameter("ownerName")));
		bean.setLocation(DataUtility.getStringData(request.getParameter("location")));
		String rent = request.getParameter("rent");
		if (rent != null && !rent.trim().isEmpty()) {
			bean.setRent(Double.parseDouble(rent));

		} else {
			bean.setRent(0.0);
		}
		bean.setRoomType(DataUtility.getStringData(request.getParameter("roomType")));
		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.PGHOSTEL_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.PGHOSTEL_CTL;

		} else {
			return ORSView.PGHOSTEL_VIEW;
		}
	}

	@Override
	protected PgHostelModel getModel() {
		return new PgHostelModel();
	}

}
