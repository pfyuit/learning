package com.pfyuit.myjavaee.service.distribute.zookeeper;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

/**
 * ZooKeeper service interface. It provides the functionality to create, delete,
 * setData, getData.
 * @author yupengfei
 */
public interface ZooKeeperService {

	public boolean exists(String path, boolean watch) throws KeeperException, InterruptedException;

	public void create(String path, byte[] data, List<ACL> acls, CreateMode mode) throws KeeperException, InterruptedException;

	public void delete(String path, int version) throws InterruptedException, KeeperException;

	public void setData(String path, byte[] data, int version) throws KeeperException, InterruptedException;

	public byte[] getData(String path, boolean watch, Stat stat) throws KeeperException, InterruptedException;

}
