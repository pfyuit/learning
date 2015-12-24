package com.pfyuit.myjavaee.dao.database.nosql.mongodb;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * MongoDB Dao interface. Including collections operations.
 * @author yupengfei
 */
public interface MongoDbDao {

	public abstract DB getDB();

	public abstract DBCollection createCollection(String collectionName);

	public abstract <T> DBCollection createCollection(Class<T> type);

	public abstract void dropCollection(String collectionName);

	public abstract <T> void dropCollection(Class<T> type);

	public abstract boolean isCollectionExists(String collectionName);

	public abstract <T> boolean isCollectionExists(Class<T> type);

	public abstract DBCollection getCollection(String collectionName);

	public abstract Set<String> getCollections();

	public abstract <T> void save(T model);

	public abstract <T> void remove(T model);

	public abstract <T> List<T> findAll(Class<T> type);

	public abstract <T> T findById(int id, Class<T> type);

}
