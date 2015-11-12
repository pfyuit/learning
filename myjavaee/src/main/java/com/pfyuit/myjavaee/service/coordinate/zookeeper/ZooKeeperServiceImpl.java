package com.pfyuit.myjavaee.service.coordinate.zookeeper;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ZooKeeper service implementation. It provides the functionality to create,
 * delete, setData, getData.
 * @author yupengfei
 */
@Service
public class ZooKeeperServiceImpl implements ZooKeeperService {

	@Autowired
	@Qualifier("zooKeeper")
	private ZooKeeper zooKeeper;

	public boolean exists(String path, boolean watch) throws KeeperException, InterruptedException {
		return zooKeeper.exists(path, watch) == null ? false : true;
	}

	public void create(String path, byte[] data, List<ACL> acls, CreateMode mode) throws KeeperException, InterruptedException {
		zooKeeper.create(path, data, acls, mode);
	}

	public void delete(String path, int version) throws InterruptedException, KeeperException {
		zooKeeper.delete(path, version);
	}

	public void setData(String path, byte[] data, int version) throws KeeperException, InterruptedException {
		zooKeeper.setData(path, data, version);
	}

	public byte[] getData(String path, boolean watch, Stat stat) throws KeeperException, InterruptedException {
		return zooKeeper.getData(path, watch, stat);
	}
}
