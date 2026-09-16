package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.QrScannerCodeBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public abstract class QrScannerCodeModel extends BaseModel<QrScannerCodeBean> {

	@Override
	public QrScannerCodeBean getBean() {
		return new QrScannerCodeBean();
	}

	@Override
	public long add(QrScannerCodeBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		QrScannerCodeBean existBean = findByQrCode(bean.getQrCode());

		if (existBean != null) {
			throw new DuplicateRecordException("find by name Exception");

		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			
			pk = nextPK();
			System.out.println("module is add start");

			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getQrCode());
			ps.setString(3, bean.getScannedBy());
			ps.setDate(4, new java.sql.Date(bean.getScanTime().getTime()));
			ps.setString(5, bean.getStatus());
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

			throw new ApplicationException("find by add exception" + e.getMessage());

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(QrScannerCodeBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;

		QrScannerCodeBean existBean = findByQrCode(bean.getQrCode());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("email id are alread exist");

		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			System.out.println("module is start");

			PreparedStatement ps = conn.prepareStatement("update " + getTable() + " set qrcode = ?, scannedby = ?, scantime = ?, status = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			ps.setString(1, bean.getQrCode());
			ps.setString(2, bean.getScannedBy());
			ps.setDate(3, new java.sql.Date(bean.getScanTime().getTime()));
			ps.setString(4, bean.getStatus());
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

			throw new ApplicationException("find by update exception" + e.getMessage());

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		
	}
	
	private QrScannerCodeBean findByQrCode(String qrCode) {
		return findByUniqueColumn("qrCode", qrCode);
	}

	@Override
	public String getWhereClause(QrScannerCodeBean bean) {
		
		StringBuffer sql = new StringBuffer();
		
		if(bean != null) {
			
			if(bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
				
			}
			
			if(bean.getQrCode() != null && bean.getQrCode().length() > 0) {
				sql.append(" and qrcode like '" + bean.getQrCode() + "%'");
			}
		}
		return sql.toString();
	}

	@Override
	public String getTable() {
		return "qrscannercode";
	}

}
