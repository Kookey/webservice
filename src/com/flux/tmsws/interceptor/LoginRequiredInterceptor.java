package com.flux.tmsws.interceptor;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.flux.tmsws.pojo.DataInfo;

public class LoginRequiredInterceptor implements MethodInterceptor  {

	@Resource
	private JdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(LoginRequiredInterceptor.class);
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object obj = invocation.getArguments()[0];
		Object result = null;
		DataInfo dataInfo = null;
		if(obj instanceof DataInfo){
			dataInfo = (DataInfo) obj;
			String sql = "select count(*) FROM rwsys_user WHERE userid = ?";
			int isExit = jdbcTemplate.queryForObject(sql, new Object[]{dataInfo.getUserId()},Integer.class );
			if(isExit>0){
				result = invocation.proceed();
			}else{
				result = "{\"UDF01\":\"111\",\"UDF02\":\"用户名在系统中不存在\"}";
				logger.error("the userId is not exit in rwsys_user");
			}
		}else{
			result = "{\"UDF01\":\"222\",\"UDF02\":\"参数必须是DataInfo对象\"}";
			logger.error("the pars be get by invocation.getArguments is not DataInfo class");
		}
		return result;
	}

	
}
