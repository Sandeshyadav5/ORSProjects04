package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class EmployeeModel extends BaseModel<EmployeeBean> {

	@Override
	public EmployeeBean getBean() {
		return new EmployeeBean();
	}

	@Override
	public long add(EmployeeBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		EmployeeBean existBean = findByEmployeeName(bean.getEmployeeName());
		
		if(existBean != null) {
			throw new DuplicateRecordException("Employee Already Exists");
		}
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pk = nextPK();
			System.out.println("add is start ");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES (?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getEmployeeName());
			pstmt.setString(3, bean.getCompany());
			pstmt.setString(4, bean.getSalary());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {

			try {
				conn.rollback();
				e.printStackTrace();

			} catch (Exception ex) {
				throw new ApplicationException("Exception is rollback " + ex.getMessage());

			}

			throw new ApplicationException("Employee is add Exception " + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;

	}

	@Override
	public void update(EmployeeBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		System.out.println("update is start");
		
		EmployeeBean existBean = findByEmployeeName(bean.getEmployeeName());
		
		if(existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Employee Already Exist");
		}
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE " + getTable() +  " SET employeename = ?, company = ?, salary = ?, dob = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ? ");
			pstmt.setString(1, bean.getEmployeeName());
			pstmt.setString(2, bean.getCompany());
			pstmt.setString(3, bean.getSalary());
			pstmt.setDate(4, new Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception : Exception is rollback" + ex.getMessage());

			}

			throw new ApplicationException("Exception is add Employee" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(EmployeeBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean.getId() > 0) {
			sql.append(" AND ID = " + bean.getId());

		}
		
		if(bean.getEmployeeName() != null && bean.getEmployeeName().length() > 0) {
			sql.append(" AND EMPLOYEENAME LIKE '" + bean.getEmployeeName() + "%'");
			
		}

		if (bean.getCompany() != null && bean.getCompany().length() > 0) {
			sql.append(" AND COMPANY LIKE '" + bean.getCompany() + "%'");
		}
		return sql.toString();
	}

	public EmployeeBean findByEmployeeName(String employeeName) {
		return findByUniqueColumn("employeename", employeeName);
	}

	@Override
	public String getTable() {
		return "employee";
	}

}
