package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.PgHostelBean;
import com.sunilos.p4.model.PgHostelModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/PgHostelListCtl")
public class PgHostelListCtl extends BaseListCtl<PgHostelBean, PgHostelModel>{
	
	@Override
	protected PgHostelBean populateBean(HttpServletRequest request) {
		PgHostelBean bean = new PgHostelBean();
		bean.setOwnerName(DataUtility.getStringData(request.getParameter("ownerName")));
		bean.setLocation(DataUtility.getStringData(request.getParameter("location")));
		String rent = request.getParameter("rent");
		if(rent != null && !rent.trim().isEmpty()) {
			bean.setRent(Double.parseDouble(rent));
			
		}else {
			bean.setRent(0.0);
		}
		bean.setRoomType(DataUtility.getStringData(request.getParameter("roomType")));
		
		return bean;
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PGHOSTEL_LIST_VIEW;
	}

	@Override
	protected String getView(String op) {
		// TODO Auto-generated method stub
		return ORSView.PGHOSTEL_LIST_VIEW;
	}

	@Override
	protected PgHostelModel getModel() {
		// TODO Auto-generated method stub
		return new PgHostelModel();
	}

}
