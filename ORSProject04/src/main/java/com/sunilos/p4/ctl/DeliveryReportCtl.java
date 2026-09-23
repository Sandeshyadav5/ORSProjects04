package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.model.DeliveryModel;

public class DeliveryReportCtl extends BaseReportCtl<DeliveryBean> {

	@Override
	public List<DeliveryBean> getList() {
		DeliveryModel model = new DeliveryModel();
		List<DeliveryBean> delivery = model.list();
		return delivery;
	}

	
	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return ORSView.DELIVERY_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "DELIVERY_LIST_COMPILE_REPORT";
	}}