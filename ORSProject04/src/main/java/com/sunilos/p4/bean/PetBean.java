package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetBean extends BaseBean {

	private String petName;
	private String ownerName;
	private String breed;
	private int age;
	private String vaccinationStatus;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return "petName";
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		
		PetBean bean = new PetBean();
		
		try {
			bean.setPetName(rs.getString("petName"));
			bean.setOwnerName(rs.getString("ownerName"));
			bean.setBreed(rs.getString("breed"));
			bean.setAge(rs.getInt("age"));
			bean.setVaccinationStatus(rs.getString("vaccinationStatus"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
