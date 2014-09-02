package com.flux.tmsws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceTest {

	private static Logger logger = LoggerFactory.getLogger(WebServiceTest.class);
	public String getParams(){
		logger.error("Hello WebService");
		return "Hello WebService";
	}
	
	public String getService(){
		return "WebServiceTest";
	}
}
