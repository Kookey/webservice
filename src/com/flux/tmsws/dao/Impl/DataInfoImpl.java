package com.flux.tmsws.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.flux.tmsws.dao.DataInfoDao;
import com.flux.tmsws.pojo.DataInfo;

public class DataInfoImpl implements DataInfoDao {

	private static final Logger logger = LoggerFactory.getLogger(DataInfoImpl.class);
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public DataInfo queryOrderTrackInfo(DataInfo dataInfo){
		StringBuffer sqlBuffer = new StringBuffer(400);
		sqlBuffer.append("SELECT S.BL_ORDER_NO AS UDF01,");
		sqlBuffer.append("S.LINE_NO AS UDF02,");
		sqlBuffer.append("S.CREATE_ORG_ID AS UDF03,");
	    sqlBuffer.append("S.CREATE_ORG_ID_NAME AS UDF04,");
	    sqlBuffer.append("S.MILESTONE_SYSCODE AS UDF05,");
	    sqlBuffer.append("S.MILESTONE_SYSCODE_NAME AS UDF06,");
	    sqlBuffer.append("S.ADDTIME AS UDF07,");
	    sqlBuffer.append("S.ADDWHO AS UDF08,");
	    sqlBuffer.append("S.ADDWHO_NAME AS UDF09,");
	    sqlBuffer.append("S.CUSTOMERNO AS UDF10,");
	    sqlBuffer.append("S.CUSTOMER_ORDER_NO AS UDF11,");
	    sqlBuffer.append("S.CURRENT_LOC_DESCR AS UDF12,");
	    sqlBuffer.append("S.ADDTIME_SH AS UDF13,");
	    sqlBuffer.append("S.ADDTIME AS UDF14,");
	    sqlBuffer.append("S.CREATESOURCE AS UDF15");
	    sqlBuffer.append(" FROM VPORTAL_DOC_BL_ORDER_HEADER_T S");
	    sqlBuffer.append(" WHERE BL_ORDER_NO = ?");
	    sqlBuffer.append(" AND CUSTOMERNO=?");
	    sqlBuffer.append(" AND ADDTIME_SH=?");
	    logger.info(sqlBuffer.toString());
	    return jdbcTemplate.query(sqlBuffer.toString(), new Object[]{dataInfo.getUDF01(),dataInfo.getUDF02(),dataInfo.getUDF07()},new ResultSetExtractor<DataInfo>(){
			@Override
			public DataInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				DataInfo resultInfo = new DataInfo();
				if(rs.next()){
					resultInfo.setUDF01(rs.getString(1));
					resultInfo.setUDF02(rs.getString(2));
					resultInfo.setUDF03(rs.getString(3));
					resultInfo.setUDF04(rs.getString(4));
					resultInfo.setUDF05(rs.getString(5));
					resultInfo.setUDF06(rs.getString(6));
					resultInfo.setUDF07(rs.getString(7));
					resultInfo.setUDF08(rs.getString(8));
					resultInfo.setUDF09(rs.getString(9));
					resultInfo.setUDF10(rs.getString(10));
					resultInfo.setUDF11(rs.getString(11));
					resultInfo.setUDF12(rs.getString(12));
					resultInfo.setUDF13(rs.getString(13));
					resultInfo.setUDF14(rs.getString(14));
					resultInfo.setUDF15(rs.getString(15));
				}
				return resultInfo;
			}});
	}
	
	public DataInfo queryCustomerInfo(DataInfo dataInfo){
		StringBuffer sqlBuffer = new StringBuffer(100);
		sqlBuffer.append("SELECT S.USERID AS UDF01, S.USERID AS UDF02, S.USER_NAME_C AS UDF03");
		sqlBuffer.append(" FROM RWSYS_USER S");
		sqlBuffer.append(" WHERE S.USERID = ?");
		logger.info(sqlBuffer.toString());
	    return jdbcTemplate.query(sqlBuffer.toString(), new Object[]{dataInfo.getUDF01()},new ResultSetExtractor<DataInfo>(){
			@Override
			public DataInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				DataInfo resultInfo = new DataInfo();
				if(rs.next()){
					resultInfo.setUDF01(rs.getString(1));
					resultInfo.setUDF02(rs.getString(2));
					resultInfo.setUDF03(rs.getString(3));
				}
				return resultInfo;
			}});
	}
}
