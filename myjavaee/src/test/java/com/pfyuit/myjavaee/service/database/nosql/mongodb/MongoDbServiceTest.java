package com.pfyuit.myjavaee.service.database.nosql.mongodb;

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
import com.pfyuit.myjavaee.model.database.nosql.mongodb.Task;

/**
 * @author yupengfei
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/nosql/mongodb/myjavaee-database-nosql-mongodb-test.xml" })
public class MongoDbServiceTest {

	@Autowired
	private MongoDbService mongodbService;

	@Test
	public void testGetDB() {
		DB db = mongodbService.getDB();
		System.out.println(db.toString());
	}

	@Test
	public void testCreateCollection() {
		if (mongodbService.isCollectionExists("Boy")) {
			return;
		}
		DBCollection collection = mongodbService.createCollection("Boy");
		System.out.println(collection.toString());
	}

	@Test
	public void testCreateCollectionWithClass() {
		if (mongodbService.isCollectionExists(Task.class)) {
			return;
		}
		DBCollection collection = mongodbService.createCollection(Task.class);
		System.out.println(collection.toString());
	}

	@Test
	@Ignore
	public void testDropCollection() {
		mongodbService.dropCollection("Boy");
	}

	@Test
	@Ignore
	public void testDropCollectionWithClass() {
		mongodbService.dropCollection(Task.class);
	}

	@Test
	public void testIsCollectionExists() {
		boolean result = mongodbService.isCollectionExists("Boy");
		System.out.println(result);
	}

	@Test
	public void testIsCollectionExistsWithClass() {
		boolean result = mongodbService.isCollectionExists(Task.class);
		System.out.println(result);
	}

	@Test
	public void testGetCollection() {
		DBCollection collection = mongodbService.getCollection("Boy");
		System.out.println(collection.toString());
	}

	@Test
	public void testGetCollections() {
		Set<String> collections = mongodbService.getCollections();
		System.out.println(collections);
	}

	@Test
	public void testSave() {
		Task task = new Task();
		task.setName("pfyuit");
		task.setAge(20);
		mongodbService.save(task);
	}

	@Test
	@Ignore
	public void testRemove() {
		Task task = new Task();
		task.setName("pfyuit");
		task.setAge(20);
		mongodbService.remove(task);
	}

	@Test
	public void testFindAll() {
		List<Task> tasks = mongodbService.findAll(Task.class);
		for (Task task : tasks) {
			System.out.println(task.getName() + ":" + task.getAge());
		}
	}

}
