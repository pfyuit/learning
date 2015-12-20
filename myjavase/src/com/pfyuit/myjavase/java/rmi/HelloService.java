package com.pfyuit.myjavase.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface of Native RMI remoting technology. Must extends Remote, the
 * business method must throws java.rmi.RemoteException.
 * @author yupengfei
 */
public interface HelloService extends Remote {

	public abstract String sayHello(String name) throws RemoteException;

}
