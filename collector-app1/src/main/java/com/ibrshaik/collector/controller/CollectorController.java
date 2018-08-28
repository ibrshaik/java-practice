package com.ibrshaik.collector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectorController {
	
	private static final Logger logger = LoggerFactory.getLogger(CollectorController.class);
	
	@RequestMapping(value="app1",method=RequestMethod.GET)
	public String getList() {
		logger.info("controller started");
		return "from Controller";
	}
}
