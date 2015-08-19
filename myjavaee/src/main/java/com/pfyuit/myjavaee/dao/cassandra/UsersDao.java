package com.pfyuit.myjavaee.dao.cassandra;

public interface UsersDao {

	public abstract void createKeySpace();

	public abstract void createTable();

	public abstract void save();

	public abstract void delete();

	public abstract void update();

	public abstract void find();

}
