package com.flux.tmsws.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.service.WSService;

public class WSController {

	private static final Logger logger = LoggerFactory.getLogger(WSController.class);
	@Resource
	private WSService wSService;
	
	public String getOrderTrackInfo(DataInfo dataInfo){
		return wSService.getDataInfoJson(dataInfo);
	}
}
