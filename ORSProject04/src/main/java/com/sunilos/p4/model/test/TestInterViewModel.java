package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.Date;

import com.sunilos.p4.bean.InterViewBean;
import com.sunilos.p4.model.InterViewModel;

public class TestInterViewModel {
	public static InterViewBean bean = new InterViewBean();

	public static void main(String[] args) {
		testAdd();

	}

	private static void testAdd() {
		InterViewModel model = new InterViewModel();
		bean.setId(1);
		bean.setCandidateName("Rakesh");
		bean.setInterviewerName("Sunil Tiwari");
		bean.setResult("pass");
		bean.setFeedBack("Interview round is Clear");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

}
