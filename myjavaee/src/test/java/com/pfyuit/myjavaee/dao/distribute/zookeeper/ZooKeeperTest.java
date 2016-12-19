package com.pfyuit.myjavaee.dao.distribute.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.dao.distribute.zookeeper.ZooKeeperDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/distribute/zookeeper/myjavaee-distribute-zookeeper-test.xml" })
public class ZooKeeperTest {

	@Autowired
	private ZooKeeperDao zooKeeperService;

	@Before
	public void init() throws KeeperException, InterruptedException {
		if (zooKeeperService.exists("/test", false)) {
			zooKeeperService.delete("/test/child1", -1);
			zooKeeperService.delete("/test/child2", -1);
			zooKeeperService.delete("/test/child3", -1);
			zooKeeperService.delete("/test", -1);
		}
		zooKeeperService.create("/test", "testdata".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zooKeeperService.create("/test/child1", "child1data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zooKeeperService.create("/test/child2", "child2data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zooKeeperService.create("/test/child3", "child3data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	@Test
	public void testCreate() throws KeeperException, InterruptedException {
		if (zooKeeperService.exists("/test", false)) {
			zooKeeperService.delete("/test/child1", -1);
			zooKeeperService.delete("/test/child2", -1);
			zooKeeperService.delete("/test/child3", -1);
			zooKeeperService.delete("/test", -1);
		}
		zooKeeperService.create("/test", "testdata".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zooKeeperService.create("/test/child1", "child1data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zooKeeperService.create("/test/child2", "child2data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zooKeeperService.create("/test/child3", "child3data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	@Test
	public void testDelete() throws KeeperException, InterruptedException {
		zooKeeperService.delete("/test/child1", -1);
		zooKeeperService.delete("/test/child2", -1);
		zooKeeperService.delete("/test/child3", -1);
		zooKeeperService.delete("/test", -1);
	}

	@Test
	public void testSetData() throws KeeperException, InterruptedException {
		zooKeeperService.setData("/test/child1", "child1data_update".getBytes(), -1);

		byte[] bytes = zooKeeperService.getData("/test/child1", false, null);
		System.out.println(new String(bytes));
	}

	@Test
	public void testGetData() throws KeeperException, InterruptedException {
		byte[] bytes = zooKeeperService.getData("/test/child1", false, null);
		System.out.println(new String(bytes));
	}

}
