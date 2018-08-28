package com.ibrshaik.quest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrshaik.quest.constants.Constants;
import com.ibrshaik.quest.model.MDOPoolingRulesOutputPayload;
import com.ibrshaik.quest.model.Member;
import com.ibrshaik.quest.model.OutputPayload;
import com.ibrshaik.quest.model.PCP;
import com.ibrshaik.quest.model.RulesInputPayload;

@Service
public class PoolService {
	
	@Autowired
	private RestClientService clientService;
	
	@Autowired
	private ProviderPoolService poolService;
	
	public OutputPayload getPool(Member member) {
		
		RulesInputPayload inputPayload = new RulesInputPayload();
		
		inputPayload.setInvocationSystem(member.getInvocationSystem());
		inputPayload.setSystemType(member.getSystemType());
		inputPayload.setMemberType(member.getMemberType());
		inputPayload.setMemberLineOfBusiness(member.getMemberLineOfBusiness());
		inputPayload.setMemberProcessingState(member.getMemberProcessingState());
		inputPayload.setMemberProductType(member.getMemberProductyType());
		
		
		MDOPoolingRulesOutputPayload mdoRulesOutput = clientService.getPoolInformation(inputPayload);
		int poolSize;
		int maxRadius;
		String dummyId;
		if(null != mdoRulesOutput) {
			poolSize = mdoRulesOutput.getRules().getPoolSize();
			maxRadius = mdoRulesOutput.getRules().getMaxRadius();
			dummyId = mdoRulesOutput.getRules().getDummyProviderId();
			
			if(null != mdoRulesOutput && Constants.ZERO != poolSize && Constants.ZERO != maxRadius ) {
				
				List<PCP> sortedByPoolList  = poolService.findByAerialDistance(member,maxRadius);
			}
			
		}
		
		
		return new OutputPayload();
	}
}
