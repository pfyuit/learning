package com.pfyuit.myjavaee.service.rule.drools;

import org.springframework.stereotype.Service;

/**
 * @author yupengfei
 */
@Service
public class BusinessServiceImpl implements BusinessService {

	@Override
	public void doBusiness() {
		System.out.println("doBusiness");
		// Database operations
		// Cache operations
		// ......
	}

}
