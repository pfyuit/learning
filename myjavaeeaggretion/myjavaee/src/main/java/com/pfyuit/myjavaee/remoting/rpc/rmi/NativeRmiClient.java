package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Native RMI client implementation.
 * @author yupengfei
 */
public class NativeRmiClient {

	public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {
		String url = "rmi://127.0.0.1/nativeRmiService";
		NativeRmiService nativeRmiService = (NativeRmiService) Naming.lookup(url);
		String result = nativeRmiService.sayHello("pfyuit");
		System.out.println(result);
	}

}
