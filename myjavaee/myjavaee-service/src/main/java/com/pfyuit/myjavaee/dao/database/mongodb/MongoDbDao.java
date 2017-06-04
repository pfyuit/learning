package com.pfyuit.myjavaee.dao.database.mongodb;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * MongoDB dao interface. Including collections operations.
 * @author yupengfei
 */
public interface MongoDbDao {

	public DB getDB();

	public DBCollection createCollection(String collectionName);

	public <T> DBCollection createCollection(Class<T> type);

	public void dropCollection(String collectionName);

	public <T> void dropCollection(Class<T> type);

	public boolean isCollectionExists(String collectionName);

	public <T> boolean isCollectionExists(Class<T> type);

	public DBCollection getCollection(String collectionName);

	public Set<String> getCollections();

	public <T> void save(T model);

	public <T> void remove(T model);

	public <T> List<T> findAll(Class<T> type);

	public <T> T findById(int id, Class<T> type);

}
