package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PgHostel is encapsulation in expert class in attributes
 * 
 * @author  Durgesh Lohiya
 * @version 1.0
 * Copyright (c) Rays EdTech
 */
public class PgHostelBean extends BaseBean {

	/**
	 * Name of Owner Hostel
	 */
	private String ownerName;
	
	/**
	 * Location or address od hostel
	 */
	private String location;
	
	/**
	 * Monthly or yearly rent of amount in Hostel
	 */
	private Double rent;
	
	/**
	 * room is Available in pgHostel in only Girls
	 */
	private String roomType;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return ownerName;
	}

	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setOwnerName(rs.getString("ownerName"));
			this.setLocation(rs.getString("location"));
			this.setRent(rs.getDouble("rent"));
			this.setRoomType(rs.getString("roomType"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
