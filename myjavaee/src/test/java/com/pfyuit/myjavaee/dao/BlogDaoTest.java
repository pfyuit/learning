package com.pfyuit.myjavaee.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.BlogModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class BlogDaoTest {

	@Autowired
	private BlogDao blogDao;

	@Test
	public void testSave() {
		BlogModel model = new BlogModel();
		model.setAuthor("pfyuit");
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
		model.setContent("content");
		blogDao.update(model);
	};

	@Test
	public void testFindById() {
		BlogModel model = blogDao.findById(3);
		assertNotNull(model);
	};

	@Test
	public void testFindAll() {
		List<BlogModel> models = blogDao.findAll();
		assertNotNull(models);
	};

}
