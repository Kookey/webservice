package com.flux.tmsws.service.Impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flux.tmsws.dao.DataInfoDao;
import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.service.WSService;

public class WSServiceImpl implements WSService {

	private static final Logger logger = LoggerFactory.getLogger(WSServiceImpl.class);
	
	@Resource
	private DataInfoDao dataInfoDao;
	
	@Override
	public String getOrderTrackJson(DataInfo dataInfo){
		DataInfo resultInfo = dataInfoDao.queryOrderTrackInfo(dataInfo);
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(resultInfo);
			logger.info(result);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public String getCustomerJson(DataInfo dataInfo) {
		DataInfo resultInfo = dataInfoDao.queryCustomerInfo(dataInfo);
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(resultInfo);
			logger.info(result);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}
		return result;
	}
}
