package com.sunilos.p4.ctl;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.model.ProductModel;
import com.sunilos.p4.model.ProductModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ProductCtl")
public class ProductCtl extends BaseCtl<ProductBean, ProductModel> {

	private static Logger log = Logger.getLogger(UserCtl.class);
	
	@Override
	protected void preload(HttpServletRequest request) {
		ProductModel model = new ProductModel();
		try {
			List l = model.list();
			request.setAttribute("productList", l);
		} catch (ApplicationException e) {
			log.error(e);
		}

	}
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("productName"))) {
			request.setAttribute("productName", PropertyReader.getValue("error.require", "productName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("productCategory"))) {
			request.setAttribute("productCategory", PropertyReader.getValue("error.require", "productCategory"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("orderDate"))) {
			request.setAttribute("orderDate", PropertyReader.getValue("error.require", "orderDate"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", PropertyReader.getValue("error.require", "price"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected ProductBean populateBean(HttpServletRequest request) {

		ProductBean bean = new ProductBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setProductName(DataUtility.getString(request.getParameter("productName")));
		bean.setProductCategory(DataUtility.getString(request.getParameter("productCategory")));
		bean.setOrderDate(DataUtility.getDate(request.getParameter("orderDate")));
		bean.setPrice(DataUtility.getInt(request.getParameter("price")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.PRODUCT_VIEW;
	}

	@Override
	protected String getView(String op) {

		if (OP_CANCEL.equalsIgnoreCase(op) || OP_DELETE.equalsIgnoreCase(op)) {
			return ORSView.PRODUCT_LIST_CTL;
		}
		return ORSView.PRODUCT_VIEW;
	}

	@Override
	protected ProductModel getModel() {
		// TODO Auto-generated method stub
		return new ProductModel();
	}

}
