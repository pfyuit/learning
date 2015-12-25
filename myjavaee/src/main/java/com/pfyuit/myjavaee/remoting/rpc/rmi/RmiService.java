package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.rmi.RemoteException;

/**
 * Interface of Spring RMI remoting technology.
 * @author yupengfei
 */
public interface RmiService {

	public String sayHello(String name) throws RemoteException;

}
