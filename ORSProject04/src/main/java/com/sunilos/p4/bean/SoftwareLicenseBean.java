package com.sunilos.p4.bean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.sunilos.p4.bean.BaseBean;

public class SoftwareLicenseBean extends BaseBean {
	private String softwareName;
	private String licenseKey;
	private Date expiryDate;
	private String vendore;

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getVendore() {
		return vendore;
	}

	public void setVendore(String vendore) {
		this.vendore = vendore;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return softwareName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setSoftwareName(rs.getString("softwarename"));
			this.setLicenseKey(rs.getString("licensekey"));
			this.setExpiryDate(rs.getDate("expirydate"));
			this.setVendore(rs.getString("vendore"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
