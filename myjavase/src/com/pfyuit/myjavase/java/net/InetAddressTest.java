package com.pfyuit.myjavase.java.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author yupengfei
 */
public class InetAddressTest {

	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName("nginx.org");
		System.out.println(addr);
		byte[] bytes = addr.getAddress();
		System.out.println(addr.getCanonicalHostName());
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		System.out.println(addr.isAnyLocalAddress());
		System.out.println(addr.isLinkLocalAddress());
		System.out.println(addr.isLoopbackAddress());
		System.out.println(addr.isMulticastAddress());
		System.out.println(addr.isReachable(5000));
		System.out.println(addr.isSiteLocalAddress());

		InetAddress[] addrs = InetAddress.getAllByName("www.apache.org");

		InetAddress localAddr = InetAddress.getLocalHost();

		InetAddress loopbackAddr = InetAddress.getLoopbackAddress();
	}

}
