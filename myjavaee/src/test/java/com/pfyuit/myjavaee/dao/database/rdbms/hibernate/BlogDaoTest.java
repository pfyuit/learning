package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import static org.junit.Assert.assertNotNull;

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

import com.pfyuit.myjavaee.info.database.rdbms.hibernate.BlogInfo;
import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;
import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CategoryModel;
import com.pfyuit.myjavaee.util.BeanUtil;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
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
	public void saveWithSession() {
		CategoryModel category = categoryDao.findByIdWithSession(5);
		BlogModel model = new BlogModel();
		model.setBlogAuthor("Example Blog Author");
		model.setBlogContent("Example Blog Content");
		model.setBlogOriginal("Example Blog Original");
		model.setBlogTitle("Example Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		model.setCategory(category);
		blogDao.saveWithSession(model);
	}

	@Test
	public void deleteWithSession() {
		BlogModel model = blogDao.findByIdWithSession(3);
		blogDao.deleteWithSession(model);
	}

	@Test
	public void deleteWithHQLQuery() {
		blogDao.deleteWithHQLQuery(3);
	}

	@Test
	public void deleteWithSQLQuery() {
		blogDao.deleteWithSQLQuery(3);
	}

	@Test
	public void updateWithSession() {
		BlogModel model = blogDao.findByIdWithSession(3);
		model.setBlogAuthor("Updated Blog Author");
		model.setBlogContent("Updated Blog Content");
		model.setBlogOriginal("Updated Blog Original");
		model.setBlogTitle("Updated Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(1));
		blogDao.updateWithSession(model);
	}

	@Test
	public void updateWithHQLQuery() {
		blogDao.updateWithHQLQuery(3);
	}

	@Test
	public void updateWithSQLQuery() {
		blogDao.updateWithSQLQuery(3);
	}

	@Test
	public void findByIdWithSession() {
		BlogModel model = blogDao.findByIdWithSession(3);
		assertNotNull(model);
		assertNotNull(model.getComments());
		BeanUtil.printModel(model);
	}

	@Test
	public void findByIdWithHQLQuery() {
		BlogModel model = blogDao.findByIdWithHQLQuery(3);
		assertNotNull(model);
		assertNotNull(model.getComments());
		BeanUtil.printModel(model);
	}

	@Test
	public void findByIdWithSQLQuery() {
		BlogInfo model = blogDao.findByIdWithSQLQuery(3);
		assertNotNull(model);
		BeanUtil.printModel(model);
	}

	@Test
	public void findByIdWithCriteria() {
		BlogModel model = blogDao.findByIdWithCriteria(3);
		assertNotNull(model);
		assertNotNull(model.getComments());
		BeanUtil.printModel(model);
	}

	@Test
	public void findByAllWithHQLQuery() {
		List<BlogModel> models = blogDao.findByAllWithHQLQuery();
		assertNotNull(models);
	}

	@Test
	public void findByAllWithSQLQuery() {
		List<BlogModel> models = blogDao.findByAllWithHQLQuery();
		assertNotNull(models);
	}

	@Test
	public void findByAllWithCriteria() {
		List<BlogModel> models = blogDao.findByAllWithHQLQuery();
		assertNotNull(models);
	}

}
