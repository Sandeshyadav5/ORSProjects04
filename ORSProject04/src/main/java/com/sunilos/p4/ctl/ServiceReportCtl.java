package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.ServiceBean;
import com.sunilos.p4.model.ServiceModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/ServiceReportCtl")
public class ServiceReportCtl extends BaseReportCtl<ServiceBean> {

	@Override
	public List<ServiceBean> getList() {

		ServiceModel model = new ServiceModel();

		List<ServiceBean> services = model.list();

		return services;
	}

	@Override
	public String getView() {
		return ORSView.SERVICE_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "SERVICE_LIST_COMPILED_REPORT";
	}
}