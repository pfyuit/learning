package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Native RMI server implementation.
 * @author yupengfei
 */
public class NativeRmiServer {

	private static Logger LOGGER = LoggerFactory.getLogger(NativeRmiServer.class);

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

			LOGGER.info("Native RMI server started at port 1099");
		} catch (Exception e) {
			LOGGER.error("Start Native RMI server failed: " + e);
		}
	}
}
