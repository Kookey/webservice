package com.flux.tmsws.dao;

import java.util.List;

import com.flux.tmsws.pojo.DataInfo;
import com.flux.tmsws.pojo.User;


public interface UserDao {

	public void deleteById(String id);
	
	public User findUser(DataInfo dataInfo);
	
	public List<User> findAll();
	
	public void updateUserById(String id);
	
	public int insertUser(User user);
}
