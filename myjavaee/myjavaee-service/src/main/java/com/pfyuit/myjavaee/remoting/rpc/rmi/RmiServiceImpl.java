package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

/**
 * Implementation of Spring RMI remoting technology.
 * @author yupengfei
 */
@Service("rmiService")
public class RmiServiceImpl implements RmiService {

	@Override
	public String sayHello(String name) throws RemoteException {
		return "Hello:" + name;
	}

}
