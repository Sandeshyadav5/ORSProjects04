package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.ServiceBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class ServiceModel extends BaseModel<ServiceBean> {

	@Override
	public ServiceBean getBean() {
		return new ServiceBean();
	}

	@Override
	public long add(ServiceBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		ServiceBean existBean = findByServiceName(bean.getServiceName());

		if (existBean != null) {
			throw new DuplicateRecordException("Service Name is already exist");
		}

		try {
			pk = nextPK();

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			System.out.println("Service module is start " + pk);

			PreparedStatement ps = conn.prepareStatement(
					"insert into " + getTable()
					+ " values(?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, pk);
			ps.setString(2, bean.getServiceName());
			ps.setDouble(3, bean.getPrice());
			ps.setString(4, bean.getDescription());
			ps.setString(5, bean.getCategory());
			ps.setString(6, bean.getCreatedBy());
			ps.setString(7, bean.getModifiedBy());
			ps.setTimestamp(8, bean.getCreatedDatetime());
			ps.setTimestamp(9, bean.getModifiedDatetime());

			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException(
						"Rollback Exception " + ex.getMessage());
			}

			throw new ApplicationException(
					"Service Add Exception " + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

	@Override
	public void update(ServiceBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		ServiceBean existBean = findByServiceName(bean.getServiceName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException(
					"Service Name is already exist");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement(
					"update " + getTable()
					+ " set service_name = ?, price = ?, description = ?, "
					+ "category = ?, created_by = ?, modified_by = ?, "
					+ "created_datetime = ?, modified_datetime = ? "
					+ "where id = ?");

			ps.setString(1, bean.getServiceName());
			ps.setDouble(2, bean.getPrice());
			ps.setString(3, bean.getDescription());
			ps.setString(4, bean.getCategory());
			ps.setString(5, bean.getCreatedBy());
			ps.setString(6, bean.getModifiedBy());
			ps.setTimestamp(7, bean.getCreatedDatetime());
			ps.setTimestamp(8, bean.getModifiedDatetime());
			ps.setLong(9, bean.getId());

			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException(
						"Rollback Exception " + ex.getMessage());
			}

			throw new ApplicationException(
					"Service Update Exception " + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	@Override
	public String getWhereClause(ServiceBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getServiceName() != null
					&& bean.getServiceName().length() > 0) {

				sql.append(" and service_name like '"
						+ bean.getServiceName() + "%'");
			}
		}

		return sql.toString();
	}

	private ServiceBean findByServiceName(String serviceName) {
		return findByUniqueColumn("service_name", serviceName);
	}

	@Override
	public String getTable() {
		return "st_service";
	}
}