package com.pfyuit.myjavaee.service.database.nosql.mongodb;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.pfyuit.myjavaee.dao.database.nosql.mongodb.MongoDbDao;

/**
 * Mongodb service implementation for MongoDB.
 * @author yupengfei
 */
@Service
public class MongoDbServiceImpl implements MongoDbService {

	@Autowired
	private MongoDbDao mongodbDao;

	@Override
	public DB getDB() {
		return mongodbDao.getDB();
	}

	@Override
	public DBCollection createCollection(String collectionName) {
		return mongodbDao.createCollection(collectionName);
	}

	@Override
	public <T> DBCollection createCollection(Class<T> type) {
		return mongodbDao.createCollection(type);
	}

	@Override
	public void dropCollection(String collectionName) {
		mongodbDao.dropCollection(collectionName);
	}

	@Override
	public <T> void dropCollection(Class<T> type) {
		mongodbDao.dropCollection(type);
	}

	@Override
	public boolean isCollectionExists(String collectionName) {
		return mongodbDao.isCollectionExists(collectionName);
	}

	@Override
	public <T> boolean isCollectionExists(Class<T> type) {
		return mongodbDao.isCollectionExists(type);
	}

	@Override
	public DBCollection getCollection(String collectionName) {
		return mongodbDao.getCollection(collectionName);
	}

	@Override
	public Set<String> getCollections() {
		return mongodbDao.getCollections();
	}

	@Override
	public <T> void save(T model) {
		mongodbDao.save(model);
	}

	@Override
	public <T> void remove(T model) {
		mongodbDao.remove(model);
	}

	@Override
	public <T> List<T> findAll(Class<T> type) {
		return mongodbDao.findAll(type);
	}

	@Override
	public <T> T findById(int id, Class<T> type) {
		return mongodbDao.findById(id, type);
	}

}
