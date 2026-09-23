package com.sunilos.p4.ctl;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.model.DeliveryModel;
import com.sunilos.p4.model.DeliveryModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/DeliveryCtl")
public class DeliveryCtl extends BaseCtl<DeliveryBean, DeliveryModel> {

	private static Logger log = Logger.getLogger(UserCtl.class);
	
	@Override
	protected void preload(HttpServletRequest request) {
		DeliveryModel model = new DeliveryModel();
		try {
			List l = model.list();
			request.setAttribute("deliveryList", l);
		} catch (ApplicationException e) {
			log.error(e);
		}

	}
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("customerName"))) {
			request.setAttribute("customerName", PropertyReader.getValue("error.require", "customerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("restaurent"))) {
			request.setAttribute("restaurent", PropertyReader.getValue("error.require", "restaurent"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("orderAmount"))) {
			request.setAttribute("orderAmount", PropertyReader.getValue("error.require", "orderAmount"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "status"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected DeliveryBean populateBean(HttpServletRequest request) {

		DeliveryBean bean = new DeliveryBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setRestaurent(DataUtility.getString(request.getParameter("restaurent")));
		bean.setOrderAmount(DataUtility.getInt(request.getParameter("orderAmount")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.DELIVERY_VIEW;
	}

	@Override
	protected String getView(String op) {

		if (OP_CANCEL.equalsIgnoreCase(op) || OP_DELETE.equalsIgnoreCase(op)) {
			return ORSView.DELIVERY_LIST_CTL;
		}
		return ORSView.DELIVERY_VIEW;
	}

	@Override
	protected DeliveryModel getModel() {
		// TODO Auto-generated method stub
		return new DeliveryModel();
	}

}
