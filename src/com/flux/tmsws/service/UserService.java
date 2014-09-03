package com.flux.tmsws.service;

import java.util.List;

import javax.annotation.Resource;

import com.flux.tmsws.dao.UserDao;
import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.pojo.User;

public class UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	public User getUserInfo(DataInfo dataInfo){
		return userDao.findUser(dataInfo);
	};
}
