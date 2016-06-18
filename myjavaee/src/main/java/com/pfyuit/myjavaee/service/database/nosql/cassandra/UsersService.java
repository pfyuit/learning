package com.pfyuit.myjavaee.service.database.nosql.cassandra;

/**
 * User interface for cassandra.
 * @author yupengfei
 */
public interface UsersService {

	public void createKeySpace();

	public void createTable();

	public void save();

	public void delete();

	public void update();

	public void find();

}
