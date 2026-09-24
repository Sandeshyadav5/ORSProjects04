package com.sunilos.p4.model;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class DeliveryModel extends BaseModel<DeliveryBean> {

	@Override
	public DeliveryBean getBean() {
		return new DeliveryBean();
	}

	@Override
	public long add(DeliveryBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		DeliveryBean existbean = findByCustomerName(bean.getCustomerName());

		if (existbean != null) {
			throw new DuplicateRecordException("customerName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getRestaurent());
			pstmt.setLong(4, bean.getOrderAmount());
			pstmt.setString(5, bean.getStatus());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add End");
		return pk;
	}

	@Override
	public void update(DeliveryBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("delivery is start");
		Connection conn = null;

		DeliveryBean existbean = findByCustomerName(bean.getCustomerName());

		if (existbean != null && existbean.getId() != bean.getId()) {
			throw new DuplicateRecordException("customerName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable()
					+ " SET customer_name = ?, restaurent = ?, order_amount = ?, status = ?, CREATED_BY = ?, MODIFIED_BY = ?, CREATED_DATETIME = ?, MODIFIED_DATETIME = ? WHERE ID = ?");
			pstmt.setString(1, bean.getCustomerName());
			pstmt.setString(2, bean.getRestaurent());
			pstmt.setLong(3, bean.getOrderAmount());
			pstmt.setString(4, bean.getStatus());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is rollback" + e.getMessage());

			}
			throw new ApplicationException("Exception is delivery add" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(DeliveryBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCustomerName() != null && bean.getCustomerName().length() > 0) {
				sql.append(" AND customer_name like '" + bean.getCustomerName() + "%'");
			}
		}

		return sql.toString();
	}

	public DeliveryBean findByCustomerName(String customerName) {
		return findByUniqueColumn("customer_name", customerName);
	}

	@Override
	public String getTable() {
		return "st_delivery";
	}

}
