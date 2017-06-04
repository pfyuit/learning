package com.pfyuit.myjavaee.remoting.rpc.rmi;

import java.rmi.RemoteException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml", "classpath*:/remoting/rpc/rmi/myjavaee-remoting-rpc-rmi-test.xml" })
public class RmiServiceTest {

	@Autowired
	@Qualifier("rmiClient")
	private RmiService rmiService;

	@Test
	public void testSayHello() throws RemoteException {
		String result = rmiService.sayHello("pfyuit");
		System.out.println(result);
	}

}
