package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBean extends BaseBean {

	private String serviceName;
	private double price;
	private String description;
	private String category;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return serviceName;
	}

	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);

		try {
			this.setServiceName(rs.getString("service_name"));
			this.setPrice(rs.getDouble("price"));
			this.setDescription(rs.getString("description"));
			this.setCategory(rs.getString("category"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}