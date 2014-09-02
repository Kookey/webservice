package com.flux.tmsws.dao;

import java.util.List;

import com.flux.tmsws.pojo.User;


public interface UserDao {

	public void deleteById(String id);
	
	public User findUserById(String id);
	
	public List<User> findAll();
	
	public void updateUserById(String id);
	
	public int insertUser(User user);
}
