package com.pfyuit.myjavaee.remoting.rpc.hessian;

import org.springframework.stereotype.Service;

/**
 * Implementation of Hessian remoting technology. Access
 * http://localhost:8080/myjavaee/springmvc/notify to test(Should be HTTP 405 if
 * using GET).
 * @author yupengfei
 */
@Service("hessianService")
public class HessianServiceImpl implements HessianService {

	@Override
	public String sayHello(String name) {
		return "Hello: " + name;
	}

}
