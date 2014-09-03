package com.flux.tmsws.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.flux.tmsws.dao.UserDao;
import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.pojo.User;

/**
 * @des AbstractTransactionalJUnit4SpringTests  事务管理继承此类
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest{

	@Resource
	private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

//	@Test
	public void testFindAll(){
		List<User> users = userDao.findAll();
		logger.warn("" + users.size());
	}
	
//	@Test
	public void testinsertUser(){
		User user = new User();
		user.setUserName("wudi");
		user.setPassword("213122");
		int affectedRows =  userDao.insertUser(user);
		Assert.assertEquals(affectedRows, 1);
		logger.warn("the number of rows affected: "+affectedRows);
	}
	
	@Test
	public void testfindUserById(){
		DataInfo dataInfo = new DataInfo();
		dataInfo.setUserId("1200315");
		dataInfo.setUDF01("2");
		User result = userDao.findUser(dataInfo);
		logger.warn(result.getId()+","+result.getPassword());
	}
}
