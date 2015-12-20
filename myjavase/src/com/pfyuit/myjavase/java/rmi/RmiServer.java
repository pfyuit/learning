package com.pfyuit.myjavase.java.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Native RMI server implementation.
 * @author yupengfei
 */
public class RmiServer {

	public static void main(String[] args) {
		try {
			/**
			 * Register the remoting object to the remote registry server.
			 * Alternatively, use the JDK command `rmiregistry 1099` instead.
			 **/
			LocateRegistry.createRegistry(1099);

			/**
			 * Bind the remote object.
			 */
			HelloService helloService = new HelloServiceImpl();
			Naming.rebind("helloService", helloService);

			System.out.println("RMI server started at port 1099");
		} catch (Exception e) {
			System.err.println("Start RMI server failed: " + e);
		}
	}
}
