package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

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

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;
import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CategoryModel;

/**
 * The transaction is rolled back by default when setting
 * "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/hibernate/myjavaee-database-rdbms-hibernate-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class BlogDaoTest {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testSave() {
		CategoryModel category = categoryDao.findById(5);

		BlogModel model = new BlogModel();
		model.setBlogAuthor("Example Blog Author");
		model.setBlogContent("Example Blog Content");
		model.setBlogOriginal("Example Blog Original");
		model.setBlogTitle("Example Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		model.setCategory(category);
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
	public void testFindAll() {
		List<BlogModel> models = blogDao.findAll();
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
