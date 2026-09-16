package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.AiScannerBean;
import com.sunilos.p4.bean.SoftwareLicenseBean;
import com.sunilos.p4.model.SoftwareLicenseModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/SoftwareLicenseReportCtl")
public class SoftwareLicenseReportCtl extends BaseReportCtl<SoftwareLicenseBean> {

	@Override
	public List<SoftwareLicenseBean> getList() {
		SoftwareLicenseModel model = new SoftwareLicenseModel();
		List<SoftwareLicenseBean> softwarelicenses = model.list();
		return softwarelicenses;

	}

	@Override
	public String getView() {
		return ORSView.SOFTWARELICENSE_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "SOFTWARELICENSE_LIST_COMPILED_REPORT";
	}

}
