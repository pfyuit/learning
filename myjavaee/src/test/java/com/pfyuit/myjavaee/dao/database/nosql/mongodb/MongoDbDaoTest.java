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
import com.pfyuit.myjavaee.dao.database.nosql.mongodb.MongoDbDao;
import com.pfyuit.myjavaee.model.database.nosql.mongodb.Task;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/nosql/mongodb/myjavaee-database-nosql-mongodb-test.xml" })
public class MongoDbDaoTest {

	@Autowired
	private MongoDbDao mongoDbDao;

	@Test
	public void testGetDB() {
		DB db = mongoDbDao.getDB();
		System.out.println(db.toString());
	}

	@Test
	public void testCreateCollection() {
		if (mongoDbDao.isCollectionExists("Boy")) {
			return;
		}
		DBCollection collection = mongoDbDao.createCollection("Boy");
		System.out.println(collection.toString());
	}

	@Test
	public void testCreateCollectionWithClass() {
		if (mongoDbDao.isCollectionExists(Task.class)) {
			return;
		}
		DBCollection collection = mongoDbDao.createCollection(Task.class);
		System.out.println(collection.toString());
	}

	@Test
	@Ignore
	public void testDropCollection() {
		mongoDbDao.dropCollection("Boy");
	}

	@Test
	@Ignore
	public void testDropCollectionWithClass() {
		mongoDbDao.dropCollection(Task.class);
	}

	@Test
	public void testIsCollectionExists() {
		boolean result = mongoDbDao.isCollectionExists("Boy");
		System.out.println(result);
	}

	@Test
	public void testIsCollectionExistsWithClass() {
		boolean result = mongoDbDao.isCollectionExists(Task.class);
		System.out.println(result);
	}

	@Test
	public void testGetCollection() {
		DBCollection collection = mongoDbDao.getCollection("Boy");
		System.out.println(collection.toString());
	}

	@Test
	public void testGetCollections() {
		Set<String> collections = mongoDbDao.getCollections();
		System.out.println(collections);
	}

	@Test
	public void testSave() {
		Task task = new Task();
		task.setName("pfyuit");
		task.setAge(20);
		mongoDbDao.save(task);
	}

	@Test
	@Ignore
	public void testRemove() {
		Task task = new Task();
		task.setName("pfyuit");
		task.setAge(20);
		mongoDbDao.remove(task);
	}

	@Test
	public void testFindAll() {
		List<Task> tasks = mongoDbDao.findAll(Task.class);
		for (Task task : tasks) {
			System.out.println(task.getName() + ":" + task.getAge());
		}
	}

}
