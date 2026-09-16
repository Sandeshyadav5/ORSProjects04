package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.SmartParkingBean;
import com.sunilos.p4.model.SmartParkingModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SmartParkingCtl")
public class SmartParkingCtl extends BaseCtl<SmartParkingBean, SmartParkingModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("parkingName"))) {
			request.setAttribute("parkingName", PropertyReader.getValue("error.require", "ParkingName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("parkingCode"))) {
			request.setAttribute("parkingCode", PropertyReader.getValue("error.require", "ParkingCode"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("vehicleNumber"))) {
			request.setAttribute("vehicleNumber", PropertyReader.getValue("error.require", "VehicleNumber"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("slotNumber"))) {
			request.setAttribute("slotNumber", PropertyReader.getValue("error.require", "SlotNumber"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}
		return pass;
	}

	@Override
	protected SmartParkingBean populateBean(HttpServletRequest request) {
		SmartParkingBean bean = new SmartParkingBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setParkingName(DataUtility.getString(request.getParameter("parkingName")));
		bean.setParkingCode(DataUtility.getString(request.getParameter("parkingCode")));
		bean.setVehicleNumber(DataUtility.getString(request.getParameter("vehicleNumber")));
		bean.setSlotNumber(DataUtility.getString(request.getParameter("slotNumber")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {

		return ORSView.SMARTPARKING_VIEW;
	}

	@Override
	protected String getView(String op) {
		// TODO Auto-generated method stub
		return ORSView.SMARTPARKING_VIEW;
	}

	@Override
	protected SmartParkingModel getModel() {
		// TODO Auto-generated method stub
		return new SmartParkingModel();
	}

}
