package com.pfyuit.myjavaee.dao.database.mongodb;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * MongoDb dao implementation. Including collections operations.
 * @author yupengfei
 */
@Repository
public class MongoDbDaoImpl implements MongoDbDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public DB getDB() {
		return mongoTemplate.getDb();
	}

	@Override
	public DBCollection createCollection(String collectionName) {
		DBCollection collection = mongoTemplate.createCollection(collectionName);
		return collection;
	}

	@Override
	public <T> DBCollection createCollection(Class<T> type) {
		DBCollection collection = mongoTemplate.createCollection(type);
		return collection;
	}

	@Override
	public void dropCollection(String collectionName) {
		mongoTemplate.dropCollection(collectionName);
	}

	@Override
	public <T> void dropCollection(Class<T> type) {
		mongoTemplate.dropCollection(type);
	}

	@Override
	public boolean isCollectionExists(String collectionName) {
		return mongoTemplate.collectionExists(collectionName);
	}

	@Override
	public <T> boolean isCollectionExists(Class<T> type) {
		return mongoTemplate.collectionExists(type);
	}

	@Override
	public DBCollection getCollection(String collectionName) {
		return mongoTemplate.getCollection(collectionName);
	}

	@Override
	public Set<String> getCollections() {
		return mongoTemplate.getCollectionNames();
	}

	@Override
	public <T> void save(T model) {
		mongoTemplate.save(model);
	}

	@Override
	public <T> void remove(T model) {
		mongoTemplate.remove(model);
	}

	@Override
	public <T> List<T> findAll(Class<T> type) {
		return mongoTemplate.findAll(type);
	}

	@Override
	public <T> T findById(final int id, Class<T> type) {
		return mongoTemplate.findById(id, type);
	}
}
