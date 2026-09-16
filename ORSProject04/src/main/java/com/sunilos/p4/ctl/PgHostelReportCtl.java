package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.PgHostelBean;
import com.sunilos.p4.model.PgHostelModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/PgHostelReportCtl")
public class PgHostelReportCtl extends BaseReportCtl<PgHostelBean>{
	
	@Override
	public List<PgHostelBean> getList() {
		PgHostelModel model = new PgHostelModel();
		List<PgHostelBean> pghostels = model.list();
		return pghostels;
	}


	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return ORSView.PGHOSTEL_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		// TODO Auto-generated method stub
		return "PGHOSTEL_LIST_COMPILED_REPORT";
	}

}
