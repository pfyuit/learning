package com.pfyuit.myjavase.java.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Native RMI server implementation.
 * @author yupengfei
 */
public class NativeRmiServer {

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
			NativeRmiService nativeRmiService = new NativeRmiServiceImpl();
			Naming.rebind("nativeRmiService", nativeRmiService);

			System.out.println("Native RMI server started at port 1099");
		} catch (Exception e) {
			System.err.println("Start Native RMI server failed: " + e);
		}
	}
}
