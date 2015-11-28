package com.pfyuit.myjavaee.service.dynamicproxy;

/**
 * @author yupengfei
 */
public class UserServiceImpl implements UserService {

	@Override
	public String sayHello(String name) {
		return "Hello: " + name;
	}

}
