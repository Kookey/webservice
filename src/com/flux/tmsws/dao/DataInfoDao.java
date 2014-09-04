package com.flux.tmsws.dao;

import com.flux.tmsws.pojo.DataInfo;

public interface DataInfoDao {

	public DataInfo queryOrderTrackInfo(DataInfo dataInfo);

	public DataInfo queryCustomerInfo(DataInfo dataInfo);

}
