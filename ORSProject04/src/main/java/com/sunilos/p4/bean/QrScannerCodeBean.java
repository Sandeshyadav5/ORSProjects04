package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class QrScannerCodeBean extends BaseBean {

	private String qrCode;
	private String scannedBy;
	private Date scanTime;
	private String status;

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getScannedBy() {
		return scannedBy;
	}

	public void setScannedBy(String scannedBy) {
		this.scannedBy = scannedBy;
	}

	public Date getScanTime() {
		return scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
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
		return qrCode;
	}

	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setId(rs.getLong("id"));
			this.setQrCode(rs.getString("qrcode"));
			this.setScannedBy(rs.getString("scannedby"));
			this.setScanTime(rs.getDate("scantime"));
			this.setStatus(rs.getString("status"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
