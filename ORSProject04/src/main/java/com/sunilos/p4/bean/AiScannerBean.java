package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AiScannerBean extends BaseBean {

	private String aiscannerName;
	private String type;
	private String description;
	private String status;

	public String getAiscannerName() {
		return aiscannerName;
	}

	public void setAiscannerName(String aiscannerName) {
		this.aiscannerName = aiscannerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return aiscannerName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setAiscannerName(rs.getString("aiscannerName"));
			this.setType(rs.getString("type"));
			this.setDescription(rs.getString("description"));
			this.setStatus(rs.getString("status"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}