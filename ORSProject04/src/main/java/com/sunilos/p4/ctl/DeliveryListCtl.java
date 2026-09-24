
package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.model.DeliveryModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/DeliveryListCtl")
public class DeliveryListCtl extends BaseListCtl<DeliveryBean, DeliveryModel> {

	@Override
	protected DeliveryBean populateBean(HttpServletRequest request) {

		DeliveryBean bean = new DeliveryBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setRestaurent(DataUtility.getString(request.getParameter("restaurent")));
		bean.setOrderAmount(DataUtility.getLong(request.getParameter("orderAmount")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}


	@Override
	protected String getView() {
		return ORSView.DELIVERY_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.DELIVERY_LIST_VIEW;
	}

	@Override
	protected DeliveryModel getModel() {
		return new DeliveryModel();
	}

}
