package com.pfyuit.myjavaee.remoting.rpc.dubbo;

/**
 * User service implementation to utilize Alibaba Dubbo framework.
 * @author yupengfei
 */
public class UserServiceImpl implements UserService {

	public String sayHello(String name) {
		return "Hello" + name;
	}

}
