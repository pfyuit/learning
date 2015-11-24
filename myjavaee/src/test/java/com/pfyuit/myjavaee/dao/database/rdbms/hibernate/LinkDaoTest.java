package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.LinkModel;

/**
 * The transaction is rolled back by default when setting
 * "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/hibernate/myjavaee-database-rdbms-hibernate-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class LinkDaoTest {

	@Autowired
	private LinkDao linkDao;

	@Test
	public void testSave() {
		LinkModel model = new LinkModel();
		model.setLinkName("Example Link Name");
		model.setLinkUrl("Example Link Url");
		linkDao.save(model);
	};

	@Test
	public void testDelete() {
		LinkModel model = linkDao.findById(1);
		linkDao.delete(model);
	};

	@Test
	public void testUpdate() {
		LinkModel model = linkDao.findById(1);
		model.setLinkName("Updated Link Name");
		model.setLinkUrl("Updated Link Url");
		linkDao.update(model);
	};

	@Test
	public void testFindById() {
		LinkModel model = linkDao.findById(1);
		assertNotNull(model);
		BlogDaoTest.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<LinkModel> models = linkDao.findAll();
		assertNotNull(models);
	};

}
