package com.pfyuit.myjavaee.dao.database.cassandra;

/**
 * User dao interface for cassandra client.
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
