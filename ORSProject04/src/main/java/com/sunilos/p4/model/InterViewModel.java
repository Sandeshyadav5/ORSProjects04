package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.InterViewBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class InterViewModel extends BaseModel<InterViewBean> {

	@Override
	public InterViewBean getBean() {
		// TODO Auto-generated method stub
		return new InterViewBean();
	}

	@Override
	public long add(InterViewBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;
		InterViewBean existBean = findByCondidateName(bean.getCandidateName());

		if (existBean != null) {
			throw new DuplicateRecordException("InterViewBean is exist");

		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();

			System.out.println(pk + "modelJdbc");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCandidateName());
			pstmt.setString(3, bean.getInterviewerName());
			pstmt.setString(4, bean.getResult());
			pstmt.setString(5, bean.getFeedBack());
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

			} catch (Exception ex) {
				throw new ApplicationException("Exception is rollback " + ex.getMessage());

			}
			throw new ApplicationException("Exception is add" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

	@Override
	public void update(InterViewBean bean) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getWhereClause(InterViewBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCandidateName() != null && bean.getCandidateName().length() > 0) {
				sql.append(" AND candidatename like '" + bean.getCandidateName() + "%'");
			}
		}
		return sql.toString();
	}

	public InterViewBean findByCondidateName(String interviewerName) {

		return findByUniqueColumn("candidatename", interviewerName);
	}

	@Override
	public String getTable() {
		// TODO Auto-generated method stub
		return "interview";
	}

}
