package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.database.rdbms.jpa.BlogModel;

/**
 * The transaction is rolled back by default when setting
 * "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/jpa/myjavaee-database-rdbms-jpa-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblogJpa", defaultRollback = true)
@Transactional
public class BlogDaoTest {

	@Autowired
	private BlogDao blogDao;

	@Test
	public void testSave() {
		// CategoryModel category = categoryDao.findById(5);

		BlogModel model = new BlogModel();
		model.setBlogAuthor("Example Blog Author");
		model.setBlogContent("Example Blog Content");
		model.setBlogOriginal("Example Blog Original");
		model.setBlogTitle("Example Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		// model.setCategory(category);
		blogDao.save(model);
	};

	@Test
	public void testDelete() {
		BlogModel model = blogDao.findById(3);
		blogDao.delete(model);
	};

	@Test
	public void testUpdate() {
		BlogModel model = blogDao.findById(3);
		model.setBlogAuthor("Updated Blog Author");
		model.setBlogContent("Updated Blog Content");
		model.setBlogOriginal("Updated Blog Original");
		model.setBlogTitle("Updated Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(1));
		blogDao.update(model);
	};

	@Test
	public void testFindById() {
		BlogModel model = blogDao.findById(3);
		assertNotNull(model);
		assertNotNull(model.getComments());
		printModel(model);
	};
	
	@Test
	public void testFindByIdByNamedQuery() {
		BlogModel model = blogDao.findByIdByNamedQuery(3);
		assertNotNull(model);
		assertNotNull(model.getComments());
		printModel(model);
	};
	
	@Test
	public void testFindByIdByNativeQuery() {
		BlogModel model = blogDao.findByIdByNativeQuery(3);
		assertNotNull(model);
		printModel(model);
	};

	@Test
	public void testFindAll() {
		List<BlogModel> models = blogDao.findAll();
		assertNotNull(models);
	};
	
	@Test
	public void testFindAllByNamedQuery() {
		List<BlogModel> models = blogDao.findAllByNamedQuery();
		assertNotNull(models);
	};

	public static <T> void printModel(T model) {
		Field[] fields = model.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				sb.append(field.get(model)).append("::");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sb.toString());
	}

}
