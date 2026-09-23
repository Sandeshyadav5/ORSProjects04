package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author  Durgesh Lohiya
 * @version 1.0
 *  Copyright (c) Rays EdTech
 */
public class DeliveryBean extends BaseBean {

	private String customerName;
	private String restaurent;
	private int orderAmount;
	private String status;
	
	
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(String restaurent) {
		this.restaurent = restaurent;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return customerName;
	}

	@Override
	public void setResultset(ResultSet rs) {

		try {
			super.setResultset(rs);
			this.setCustomerName(rs.getString("customer_name"));
			this.setRestaurent(rs.getString("restaurent"));
			this.setOrderAmount(orderAmount);
			this.setStatus(rs.getString("status"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
