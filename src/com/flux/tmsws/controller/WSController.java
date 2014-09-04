package com.flux.tmsws.controller;

import javax.annotation.Resource;

import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.service.WSService;

public class WSController {

	@Resource
	private WSService wSService;
	
	public String getOrderTrackInfo(DataInfo dataInfo){
		return wSService.getOrderTrackJson(dataInfo);
	}
	
	public String getCustomerInfo(DataInfo dataInfo){
		return wSService.getCustomerJson(dataInfo);
	}
}
