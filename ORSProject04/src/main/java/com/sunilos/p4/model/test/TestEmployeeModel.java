package com.sunilos.p4.model.test;

import java.sql.Timestamp;
import java.util.Date;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.model.EmployeeModel;

public class TestEmployeeModel {
	public static EmployeeBean bean = new EmployeeBean();

	public static void main(String[] args) {
//		testadd();
//		testdelete();
		testupdate();

	}

	private static void testupdate() {

		try {
			EmployeeModel model = new EmployeeModel();
			EmployeeBean bean = model.findByPK(3L);

			if (bean == null) {
				System.out.println("Employee Not found");
				return;
			}

			bean.setEmployeeName("Durgesh Lohiya");
			bean.setCompany("Deloite");
			bean.setSalary("200000");
			bean.setDob(new java.util.Date());

			model.update(bean);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void testdelete() {

		try {
			EmployeeModel model = new EmployeeModel();
			long pk = 1L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("delete is success" + bean.getId());

			EmployeeBean deleteBean = model.findByPK(pk);

			if (deleteBean == null) {
				System.out.println("deleteBean is fails");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void testadd() {
		EmployeeModel model = new EmployeeModel();
		bean.setId(1);
		bean.setEmployeeName("Durgesh Lohiya");
		bean.setCompany("Amazon");
		bean.setSalary("5000000");
		bean.setDob(new java.util.Date());
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long id = model.add(bean);
		System.out.println("Employee Is added");

	}

}
