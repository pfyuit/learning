package com.pfyuit.myjavaee.dao.database.nosql.mongodb;

import java.util.List;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.pfyuit.myjavaee.dao.database.nosql.mongodb.MongoDBDao;
import com.pfyuit.myjavaee.model.database.nosql.mongodb.Task;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class MongoDBDaoTest {

	@Autowired
	private MongoDBDao mongoDBDao;

	@Test
	public void testGetDB() {
		DB db = mongoDBDao.getDB();
		System.out.println(db.toString());
	}

	@Test
	public void testCreateCollection() {
		if (mongoDBDao.isCollectionExists("Boy")) {
			return;
		}
		DBCollection collection = mongoDBDao.createCollection("Boy");
		System.out.println(collection.toString());
	}

	@Test
	public void testCreateCollectionWithClass() {
		if (mongoDBDao.isCollectionExists(Task.class)) {
			return;
		}
		DBCollection collection = mongoDBDao.createCollection(Task.class);
		System.out.println(collection.toString());
	}

	@Test
	@Ignore
	public void testDropCollection() {
		mongoDBDao.dropCollection("Boy");
	}

	@Test
	@Ignore
	public void testDropCollectionWithClass() {
		mongoDBDao.dropCollection(Task.class);
	}

	@Test
	public void testIsCollectionExists() {
		boolean result = mongoDBDao.isCollectionExists("Boy");
		System.out.println(result);
	}

	@Test
	public void testIsCollectionExistsWithClass() {
		boolean result = mongoDBDao.isCollectionExists(Task.class);
		System.out.println(result);
	}

	@Test
	public void testGetCollection() {
		DBCollection collection = mongoDBDao.getCollection("Boy");
		System.out.println(collection.toString());
	}

	@Test
	public void testGetCollections() {
		Set<String> collections = mongoDBDao.getCollections();
		System.out.println(collections);
	}

	@Test
	public void testSave() {
		Task task = new Task();
		task.setName("pfyuit");
		task.setAge(20);
		mongoDBDao.save(task);
	}

	@Test
	@Ignore
	public void testRemove() {
		Task task = new Task();
		task.setName("pfyuit");
		task.setAge(20);
		mongoDBDao.remove(task);
	}

	@Test
	public void testFindAll() {
		List<Task> tasks = mongoDBDao.findAll(Task.class);
		for (Task task : tasks) {
			System.out.println(task.getName() + ":" + task.getAge());
		}
	}

}
