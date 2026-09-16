package com.sunilos.p4.ctl;

import org.jfree.data.DataUtilities;

import com.sunilos.p4.bean.InterViewBean;
import com.sunilos.p4.model.InterViewModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/InterViewCtl")
public class InterViewCtl extends BaseCtl<InterViewBean, InterViewModel>{
	
	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		
		if(DataValidator.isNull(request.getParameter("candidatename"))) {
			request.setAttribute("candidatename", PropertyReader.getValue("error.require", "CandidateName"));
			pass = false;
			
		}
		
		if(DataValidator.isNull(request.getParameter("interviewername"))) {
			request.setAttribute("interviewername", PropertyReader.getValue("error.require", "InterViewer"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("result"))) {
			request.setAttribute("result", PropertyReader.getValue("error.require", "Result"));
			pass = false;
			
		}
		
		if(DataValidator.isNull(request.getParameter("feedback"))) {
			request.setAttribute("feedback", PropertyReader.getValue("error.require", "FeedBack"));
			pass = false;
		}
		return pass;
		
	}
	
	@Override
	protected InterViewBean populateBean(HttpServletRequest request) {
		InterViewBean bean = new InterViewBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCandidateName(DataUtility.getStringData(request.getParameter("candidatename")));
		bean.setInterviewerName(DataUtility.getStringData(request.getParameter("interviewername")));
		bean.setResult(DataUtility.getString(request.getParameter("result")));
		bean.setFeedBack(DataUtility.getStringData(request.getParameter("feedbanck")));
		
		populateDTO(bean, request);
		
		return bean;
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.INTERVIEW_VIEW;
	}

	@Override
	protected String getView(String op) {
		if(OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.INTERVIEW_CTL;
		}
		return ORSView.INTERVIEW_VIEW;
	}

	@Override
	protected InterViewModel getModel() {
		// TODO Auto-generated method stub
		return new InterViewModel();
	}

}
