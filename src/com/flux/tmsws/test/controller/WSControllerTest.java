package com.flux.tmsws.test.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.service.WSService;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class WSControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(WSControllerTest.class);
	@Resource
	private WSService wSService;
	
	@Test
	public void getOrderTrackInfoTest(){
		DataInfo dataInfo = new DataInfo();
		String result = wSService.getDataInfoJson(dataInfo);
		logger.warn(result);
	}
}
