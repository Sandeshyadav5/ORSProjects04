package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.Date;

import com.sunilos.p4.bean.PgHostelBean;
import com.sunilos.p4.model.PgHostelModel;

public class TestPgHostelModel {
	
	public static void main(String[] args) {
		testadd();
		
		
	}

	private static void testadd() {
		PgHostelBean bean = new PgHostelBean();
		PgHostelModel model = new PgHostelModel();
		
		bean.setId(1);
		bean.setOwnerName("Abhi Tiwari");
		bean.setLocation("Indore Madhya Pradesh");
		bean.setRent(1000.0);
		bean.setRoomType("Available");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long id = model.add(bean);
		System.out.println("PgHostel is add" + id);
		
		
	}

}
