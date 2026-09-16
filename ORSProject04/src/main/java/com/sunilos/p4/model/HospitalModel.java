package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.HospitalBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class HospitalModel extends BaseModel<HospitalBean> {

	@Override
	public HospitalBean getBean() {
		// TODO Auto-generated method stub
		return new HospitalBean();
	}

	@Override
	public long add(HospitalBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		HospitalBean existBean = findByPatientName(bean.getPatientName());

		if (existBean != null) {
			throw new DuplicateRecordException("Exception is hospitalName");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			pk = nextPK();

			System.out.println("hospital module " + pk);

			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getPatientName());
			ps.setString(3, bean.getDisease());
			ps.setString(4, bean.getDoctorName());
			ps.setDate(5, new Date(bean.getAdmissionDate().getTime()));
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
				throw new ApplicationException("Exception is rollback" + ex.getMessage());
				// TODO: handle exception
			}
			throw new ApplicationException("Exception is Hospital add" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(HospitalBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		HospitalBean existBean = findByPatientName(bean.getPatientName());

		if (existBean != null && existBean.getId() == bean.getId()) {
			throw new DuplicateRecordException("PatientName already exists !!");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement("update " + getTable() + " set patient_name = ?, disease = ?, doctor_name = ?, admission_date = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			ps.setString(1, bean.getPatientName());
			ps.setString(2, bean.getDisease());
			ps.setString(3, bean.getDoctorName());
			ps.setDate(4, new Date(bean.getAdmissionDate().getTime()));
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
				throw new ApplicationException("Exception is rollback" + ex.getMessage());
				// TODO: handle exception
			}
			throw new ApplicationException("Exception is Hospital update" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}

	@Override
	public String getWhereClause(HospitalBean bean) {
		
		StringBuffer sql = new StringBuffer();
		
		if(bean != null) {
			
			if(bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
				
			}
			
			if(bean.getPatientName() != null && bean.getPatientName().length() > 0) {
				sql.append(" and patientName like '" + bean.getPatientName() + "%'");
			}
		}
		return sql.toString();
		

	}

	private HospitalBean findByPatientName(String patientName) {
		return findByUniqueColumn("patient_name", patientName);
		
	}

	@Override
	public String getTable() {
		// TODO Auto-generated method stub
		return "hospital";
	}

}
