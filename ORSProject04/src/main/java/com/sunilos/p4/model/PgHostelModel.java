package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sunilos.p4.bean.PgHostelBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class PgHostelModel extends BaseModel<PgHostelBean> {

	@Override
	public PgHostelBean getBean() {
		// TODO Auto-generated method stub
		return new PgHostelBean();
	}

	@Override
	public long add(PgHostelBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		PgHostelBean existBean = findByOwnerName(bean.getOwnerName());

		if (existBean != null) {
			throw new DuplicateRecordException("FindByOwnerName Is Excpetion");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			pk = nextPK();
			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getOwnerName());
			ps.setString(3, bean.getLocation());
			ps.setDouble(4, bean.getRent());
			ps.setString(5, bean.getRoomType());
			ps.setString(6, bean.getCreatedBy());
			ps.setString(7, bean.getModifiedBy());
			ps.setTimestamp(8, bean.getCreatedDatetime());
			ps.setTimestamp(9, bean.getModifiedDatetime());
			ps.executeUpdate(); // int i = executeupdate // resultset rs = executeQuery
			conn.commit();
			ps.close();

		} catch (Exception e) {
			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is rollback" + ex.getMessage());

			}
			throw new ApplicationException("Exception is PgHostel add" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(PgHostelBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		PgHostelBean existBean = findByOwnerName(bean.getOwnerName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Email id Alreay exist");

		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("update " + getTable()
					+ " set ownername = ?, location = ?, rent = ?, roomtype = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			ps.setString(1, bean.getOwnerName());
			ps.setString(2, bean.getLocation());
			ps.setDouble(3, bean.getRent());
			ps.setString(4, bean.getRoomType());
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
			throw new ApplicationException("Exception is Pghostel update" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(PgHostelBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());

			}

			if (bean.getOwnerName() != null && bean.getOwnerName().length() > 0) {
				sql.append(" and ownerName like '" + bean.getOwnerName() + "%'");
			}
		}
		
		return sql.toString();

	}

	private PgHostelBean findByOwnerName(String ownerName) {
		return findByUniqueColumn("ownerName", ownerName);
	}

	@Override
	public String getTable() {
		// TODO Auto-generated method stub
		return "pg_hostel";
	}

}
