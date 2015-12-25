package com.pfyuit.myjavaee.dao.database.nosql.cassandra;

/**
 * User Dao interface for Cassandra client.
 * @author yupengfei
 */
public interface UsersDao {

	public void createKeySpace();

	public void createTable();

	public void save();

	public void delete();

	public void update();

	public void find();

}
