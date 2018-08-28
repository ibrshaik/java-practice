package com.ibrshaik.quest.service;

import com.ibrshaik.quest.model.MDOPoolingRules;
import com.ibrshaik.quest.model.MDOPoolingRulesOutputPayload;
import com.ibrshaik.quest.model.RulesInputPayload;

public class RestClientService {
	
	
	public MDOPoolingRulesOutputPayload getPoolInformation(RulesInputPayload input) {
		MDOPoolingRulesOutputPayload payload = new MDOPoolingRulesOutputPayload();
		MDOPoolingRules rules = new MDOPoolingRules();
		
		rules.setDummyProviderId("DUMMYCT0");
		rules.setMaxRadius(10);
		rules.setPoolSize(1000);
		payload.setRules(rules);
		
		return payload;
	}
}
