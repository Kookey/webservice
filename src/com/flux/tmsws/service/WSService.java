package com.flux.tmsws.service;

import com.flux.tmsws.pojo.DataInfo;

public interface WSService {

	public String getOrderTrackJson(DataInfo dataInfo);

	public String getCustomerJson(DataInfo dataInfo);

}
