package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.AiScannerBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class AiScannerModel extends BaseModel<AiScannerBean>{
	

	@Override
	public AiScannerBean getBean() {
		return new AiScannerBean();
	}


	@Override
	public long add(AiScannerBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;
		
		AiScannerBean existBean = findByAiScannerName(bean.getAiscannerName());
		
		if(existBean != null) {
			throw new DuplicateRecordException("Find By Name is already exist");
		}
		
		try {
			pk = nextPK();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			System.out.println("module is start" + pk);
			
			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getAiscannerName());
			ps.setString(3, bean.getDescription());
			ps.setString(4, bean.getType());
			ps.setString(5, bean.getStatus());
			ps.setString(6, bean.getCreatedBy());
			ps.setString(7, bean.getModifiedBy());
			ps.setTimestamp(8, bean.getCreatedDatetime());
			ps.setTimestamp(9, bean.getModifiedDatetime());
			ps.executeUpdate();
			conn.commit();
			ps.close();
			
		}
		
		catch (Exception e) {
			
			try {
				conn.rollback();
				
			}catch(Exception ex) {
				throw new ApplicationException("findbyAdd Exception" + ex.getMessage());
				
			}
			throw new ApplicationException("FindByUpdate Exception");
			
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return pk;
	}


	@Override
	public void update(AiScannerBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		int pk = 0;
		
		AiScannerBean existBean = findByAiScannerName(bean.getAiscannerName());
		
		if(existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("email id is already exist");
		}
		
		try {
			pk = nextPK();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			System.out.println("module is start" + pk);
			
			PreparedStatement ps = conn.prepareStatement("update " + getTable() + " set aiscannername = ?, type = ?, description = ?, status = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
			ps.setString(1, bean.getAiscannerName());
			ps.setString(2, bean.getDescription());
			ps.setString(3, bean.getType());
			ps.setString(4, bean.getStatus());
			ps.setString(5, bean.getCreatedBy());
			ps.setString(6, bean.getModifiedBy());
			ps.setTimestamp(7, bean.getCreatedDatetime());
			ps.setTimestamp(8, bean.getModifiedDatetime());
			ps.setLong(9, bean.getId());
			ps.executeUpdate();
			conn.commit();
			ps.close();
			
		}
		
		catch (Exception e) {
			
			try {
				conn.rollback();
				
			}catch(Exception ex) {
				throw new ApplicationException("findby rollback Exception" + ex.getMessage());
				
			}
			throw new ApplicationException("FindBy Exception" + e.getMessage());
			
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}

	@Override
	public String getWhereClause(AiScannerBean bean) {
		
		StringBuffer sql = new StringBuffer();
		
		if(bean != null) {
			
			if(bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			
			if(bean.getAiscannerName() != null && bean.getAiscannerName().length() > 0) {
				sql.append(" and aiscannername like '" + bean.getAiscannerName() + "%'");
			}
		}
		return sql.toString();
	}

	private AiScannerBean findByAiScannerName(String aiscannerName) {
		return findByUniqueColumn("aiscannerName", aiscannerName);
	}
	
	@Override
	public String getTable() {
		return "aiscannername";
	}

}
