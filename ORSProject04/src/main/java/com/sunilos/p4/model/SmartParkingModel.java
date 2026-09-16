package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.SmartParkingBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class SmartParkingModel extends BaseModel<SmartParkingBean> {

	@Override
	public SmartParkingBean getBean() {
		return new SmartParkingBean();
	}

	@Override
	public long add(SmartParkingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		int pk = 0;
		pk = nextPK();

		SmartParkingBean existBean = findByParkingName(bean.getParkingName());

		if (existBean != null) {
			throw new DuplicateRecordException("Find by ParkingName Exception");
		}

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			System.out.println("model is add Start");

			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getParkingName());
			ps.setString(3, bean.getParkingCode());
			ps.setString(4, bean.getVehicleNumber());
			ps.setString(5, bean.getSlotNumber());
			ps.setString(6, bean.getStatus());
			ps.setString(7, bean.getCreatedBy());
			ps.setString(8, bean.getModifiedBy());
			ps.setTimestamp(9, bean.getCreatedDatetime());
			ps.setTimestamp(10, bean.getModifiedDatetime());
			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is  rollback" + ex.getMessage());

			}
			throw new ApplicationException("Exception is find add" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;

	}

	private SmartParkingBean findByParkingName(String parkingName) {
		return findByUniqueColumn("parkingname", parkingName);
	}

	@Override
	public void update(SmartParkingBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		SmartParkingBean existBean = findByParkingName(bean.getParkingName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("email id already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			System.out.println("model is update Start");

			PreparedStatement ps = conn.prepareStatement("update " + getTable()
					+ " set parkingname = ?, parkingcode = ?, vehiclenumber = ?, slotnumber = ?, status = ?, created_by = ?, modified_by = ? where id = ?");
			ps.setString(1, bean.getParkingName());
			ps.setString(2, bean.getParkingCode());
			ps.setString(3, bean.getVehicleNumber());
			ps.setString(4, bean.getSlotNumber());
			ps.setString(5, bean.getStatus());
			ps.setString(6, bean.getCreatedBy());
			ps.setString(7, bean.getModifiedBy());
			ps.setTimestamp(8, bean.getCreatedDatetime());
			ps.setTimestamp(9, bean.getModifiedDatetime());
			ps.setLong(10, bean.getId());
			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is  rollback" + ex.getMessage());

			}
			throw new ApplicationException("Exception is find update" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(SmartParkingBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getParkingCode() != null && bean.getParkingCode().length() > 0) {
				sql.append(" and parkingcode like '" + bean.getParkingCode() + "%'");
			}
		}
		return sql.toString();
	}

	@Override
	public String getTable() {
		return "smartparking";
	}

}
