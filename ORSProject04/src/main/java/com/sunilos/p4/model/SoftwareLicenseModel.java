package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.SoftwareLicenseBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class SoftwareLicenseModel extends BaseModel<SoftwareLicenseBean> {



	@Override
	public long add(SoftwareLicenseBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		SoftwareLicenseBean existbean = findBySoftwareName(bean.getSoftwareName());

		if (existbean != null) {
			throw new DuplicateRecordException("Email id Alreay exist");

		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			pk = nextPK();

			System.out.println("model is start" + pk);

			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getSoftwareName());
			ps.setString(3, bean.getLicenseKey());
			ps.setDate(4, new Date(bean.getExpiryDate().getTime()));
			ps.setString(5, bean.getVendore());
			ps.setString(6, bean.getCreatedBy());
			ps.setString(7, bean.getModifiedBy());
			ps.setTimestamp(8, bean.getCreatedDatetime());
			ps.setTimestamp(9, bean.getModifiedDatetime());
			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is rollback" + ex.getMessage());
			}
			throw new ApplicationException(" SoftwareLicense is exist" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(SoftwareLicenseBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		SoftwareLicenseBean existebean = findBySoftwareName(bean.getSoftwareName());

		if (existebean != null && existebean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Email id Already exist");

		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement("update " + getTable()
					+ " set softwarename = ?, licensekey = ?, expirydate = ?, vendore = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			ps.setString(1, bean.getSoftwareName());
			ps.setString(2, bean.getLicenseKey());
			ps.setDate(3, new Date(bean.getExpiryDate().getTime()));
			ps.setString(4, bean.getVendore());
			ps.setString(5, bean.getCreatedBy());
			ps.setString(6, bean.getModifiedBy());
			ps.setTimestamp(7, bean.getCreatedDatetime());
			ps.setTimestamp(8, bean.getModifiedDatetime());
			ps.setLong(9, bean.getId());
			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is rollback" + ex.getMessage());
			}
			throw new ApplicationException("Exception is SoftwareLicense update" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	private SoftwareLicenseBean findBySoftwareName(String softwareName) {
		return findByUniqueColumn("softwareName", softwareName);
	}

	@Override
	public String getWhereClause(SoftwareLicenseBean bean) {

		StringBuffer sql = new StringBuffer();
		
		if(bean != null) {

		if (bean.getId() > 0) {
			sql.append(" and id = " + bean.getId());
		}

		if (bean.getSoftwareName() != null && bean.getSoftwareName().length() > 0) {
			sql.append(" and softwarename like '" + bean.getSoftwareName() + "%'");

		}
	}
		return sql.toString();
	}
	

	

	@Override
	public String getTable() {
		return "software_license";
	}

	@Override
	public SoftwareLicenseBean getBean() {
		return new SoftwareLicenseBean();
	}

}
