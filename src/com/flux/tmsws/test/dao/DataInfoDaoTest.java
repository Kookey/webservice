package com.flux.tmsws.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.flux.tmsws.dao.DataInfoDao;
import com.flux.tmsws.pojo.DataInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DataInfoDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(DataInfoDaoTest.class);
	@Resource
	private DataInfoDao dataInfoDao;
	
	@Test
	public void getOrderTrackInfoTest(){
		DataInfo dataInfo = new DataInfo();
		dataInfo.setUDF01("0016960355");
		dataInfo.setUDF02("XJTCPC021002");
		dataInfo.setUDF07("2013-09-23 08:26");
		dataInfo.setUserId("XJTCPC021002");
		DataInfo result =dataInfoDao.queryOrderTrackInfo(dataInfo);
		logger.warn(result.getUDF01());
	}
}
