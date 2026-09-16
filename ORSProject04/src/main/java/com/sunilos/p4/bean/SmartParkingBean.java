package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunilos.p4.bean.BaseBean;

public class SmartParkingBean extends BaseBean {
	private String parkingName;
	private String parkingCode;
	private String vehicleNumber;
	private String slotNumber;
	private String status;

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public String getParkingCode() {
		return parkingCode;
	}

	public void setParkingCode(String parkingCode) {
		this.parkingCode = parkingCode;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return parkingName;

	}

	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setParkingName(rs.getString("parkingName"));
			this.setParkingCode(rs.getString("parkingCode"));
			this.setVehicleNumber(rs.getString("vehicleNumber"));
			this.setSlotNumber(rs.getString("slotNumber"));
			this.setStatus(rs.getString("status"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
