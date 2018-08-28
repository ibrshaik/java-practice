package com.ibrshaik.quest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibrshaik.quest.model.Member;
import com.ibrshaik.quest.model.OutputPayload;
import com.ibrshaik.quest.service.PoolService;

@RestController
public class QuestController {
	
	private static final Logger logger = LoggerFactory.getLogger(QuestController.class);
	
	@Autowired
	private PoolService poolservice;
	
	@RequestMapping(value="quest",method = RequestMethod.POST)
	public String getList(@RequestBody Member member) {
		logger.info("controller started {} ","");
		
		OutputPayload output = poolservice.getPool(member);
		logger.info("output {} ",output);
		return "new String ";
	}
}
