package com.pfyuit.myjavase.java.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementation of Native RMI remoting technology.The business method must
 * throws java.rmi.RemoteException.
 * @author yupengfei
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

	private static final long serialVersionUID = -4310437749447183982L;

	protected HelloServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		return "Hello:" + name;
	}

}
