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
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testSave() {
		CategoryModel model = new CategoryModel();
		model.setCategoryName("Example Category");
		model.setCreateTime(new Timestamp(new Date().getTime()));
		model.setSortId(1);
		categoryDao.save(model);
	};

	@Test
	public void testDelete() {
		CategoryModel model = categoryDao.findById(5);
		categoryDao.delete(model);
	};

	@Test
	public void testUpdate() {
		CategoryModel model = categoryDao.findById(5);
		model.setCategoryName("Updated Category");
		model.setCreateTime(new Timestamp(new Date().getTime()));
		model.setSortId(2);
		categoryDao.update(model);
	};

	@Test
	public void testFindById() {
		CategoryModel model = categoryDao.findById(5);
		assertNotNull(model);
		assertNotNull(model.getBlogs());
		BlogDaoTest.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<CategoryModel> models = categoryDao.findAll();
		assertNotNull(models);
	};

}
