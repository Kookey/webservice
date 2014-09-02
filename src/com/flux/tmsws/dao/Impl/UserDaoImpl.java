package com.flux.tmsws.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.flux.tmsws.dao.UserDao;
import com.flux.tmsws.pojo.User;

public class UserDaoImpl implements UserDao{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Cacheable(value="userCache")
	public List<User> findAll() {
		
		final List<User> users = new ArrayList<User>();
		String sql = "select password,username from TEST_USER";
		logger.debug(sql);
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet resultSet) throws SQLException {
				User user = new User();
				user.setPassword(resultSet.getString(1));
				user.setUserName(resultSet.getString(2));
				users.add(user);
			}
		});
		return users;
	}

	@Override
	public void updateUserById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@CacheEvict(value="userCache")
	public int insertUser(User user) {
		String sql = "insert into TEST_USER(username,password) values (?,?)";
		return jdbcTemplate.update(sql, new Object[]{user.getUserName(),user.getPassword()});
	}
}
