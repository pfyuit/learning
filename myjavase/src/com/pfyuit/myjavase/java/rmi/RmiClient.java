package com.pfyuit.myjavase.java.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Native RMI client implementation.
 * @author yupengfei
 */
public class RmiClient {

	public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {
		String url = "rmi://127.0.0.1/helloService";
		HelloService helloService = (HelloService) Naming.lookup(url);
		String result = helloService.sayHello("pfyuit");
		System.out.println(result);
	}

}
