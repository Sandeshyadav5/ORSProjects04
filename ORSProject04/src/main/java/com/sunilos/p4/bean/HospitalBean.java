package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.sunilos.p4.bean.BaseBean;

public class HospitalBean extends BaseBean {

	private long id;
	private String patientName;
	private String disease;
	private String doctorName;
	private Date admissionDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return patientName ;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setId(rs.getLong("id"));
			this.setPatientName(rs.getString("patient_name"));
			this.setDisease(rs.getString("disease"));
			this.setDoctorName(rs.getString("doctor_name"));
			this.setAdmissionDate(rs.getDate("admission_date"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
