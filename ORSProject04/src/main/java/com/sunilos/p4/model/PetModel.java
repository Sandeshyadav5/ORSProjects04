package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sunilos.p4.bean.PetBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class PetModel extends BaseModel<PetBean> {

	@Override
	public PetBean getBean() {
		return new PetBean();
	}

	@Override
	public long add(PetBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		PetBean existBean = findByPetName(bean.getPetName());
		if (existBean != null) {
			throw new DuplicateRecordException("name is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			pk = nextPK();
			System.out.println("model is start add" + pk);
			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getPetName());
			ps.setString(3, bean.getOwnerName());
			ps.setString(4, bean.getBreed());
			ps.setInt(5, bean.getAge());
			ps.setString(6, bean.getVaccinationStatus());
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
				throw new ApplicationException("find by rollbackException" + ex.getMessage());

			}

			throw new ApplicationException("find by exception add" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

	@Override
	public void update(PetBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		PetBean existBean = findByPetName(bean.getPetName());
		if (existBean != null && existBean.getId() == bean.getId()) {
			throw new DuplicateRecordException("email is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			System.out.println("model is start update");
			PreparedStatement ps = conn.prepareStatement("update from " + getTable()
					+ " set petname = ?, ownername = ?, breed = ?, age = ?, vaccinationstatus = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			ps.setString(1, bean.getPetName());
			ps.setString(2, bean.getOwnerName());
			ps.setString(3, bean.getBreed());
			ps.setInt(4, bean.getAge());
			ps.setString(5, bean.getVaccinationStatus());
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
				throw new ApplicationException("find by rollbackException" + ex.getMessage());

			}

			throw new ApplicationException("find by exceptio update" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	@Override
	public String getWhereClause(PetBean bean) {
		
		StringBuffer sql = new StringBuffer();
		
		if(bean != null) {
			
			if(bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
				
			}
			
			if(bean.getPetName() != null && bean.getPetName().length() > 0) {
				sql.append(" and petName like '" + bean.getPetName() + "%'");
			}
		}
		
		return sql.toString();
	}

	public PetBean findByPetName(String petName) {
		return findByUniqueColumn("petName", petName);
	}

	@Override
	public String getTable() {
		return "pet";
	}

}
