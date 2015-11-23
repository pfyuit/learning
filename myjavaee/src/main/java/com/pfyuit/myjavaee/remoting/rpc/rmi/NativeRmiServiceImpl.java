package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementation of Native RMI remoting technology.The business method must
 * throws java.rmi.RemoteException.
 * @author yupengfei
 */
public class NativeRmiServiceImpl extends UnicastRemoteObject implements NativeRmiService {

	private static final long serialVersionUID = -4310437749447183982L;

	protected NativeRmiServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		return "Hello:" + name;
	}

}
