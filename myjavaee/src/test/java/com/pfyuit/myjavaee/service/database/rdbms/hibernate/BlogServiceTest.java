package com.pfyuit.myjavaee.service.database.rdbms.hibernate;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;
import com.pfyuit.myjavaee.service.database.rdbms.hibernate.BlogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class BlogServiceTest {

	@Autowired
	private BlogService blogService;

	@Test
	public void testSave() {
		BlogModel model = new BlogModel();
		model.setAuthor("pfyuit");
		blogService.save(model);
	};

	@Test
	public void testDelete() {
		BlogModel model = blogService.findById(3);
		blogService.delete(model);
	};

	@Test
	public void testUpdate() {
		BlogModel model = blogService.findById(3);
		model.setContent("content");
		blogService.update(model);
	};

	@Test
	public void testFindById() {
		BlogModel model = blogService.findById(3);
		assertNotNull(model);
	};

	@Test
	public void testFindAll() {
		List<BlogModel> models = blogService.findAll();
		assertNotNull(models);
	};

}
