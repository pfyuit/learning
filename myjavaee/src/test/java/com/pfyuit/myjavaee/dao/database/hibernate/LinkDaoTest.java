package com.pfyuit.myjavaee.dao.database.hibernate;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.database.hibernate.LinkDao;
import com.pfyuit.myjavaee.model.database.hibernate.LinkModel;
import com.pfyuit.myjavaee.util.BeanUtil;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/hibernate/myjavaee-database-hibernate-test.xml" })
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
		linkDao.saveWithSession(model);
	};

	@Test
	public void testDelete() {
		LinkModel model = linkDao.findByIdWithSession(1);
		linkDao.deleteWithSession(model);
	};

	@Test
	public void testUpdate() {
		LinkModel model = linkDao.findByIdWithSession(1);
		model.setLinkName("Updated Link Name");
		model.setLinkUrl("Updated Link Url");
		linkDao.updateWithSession(model);
	};

	@Test
	public void testFindById() {
		LinkModel model = linkDao.findByIdWithSession(1);
		assertNotNull(model);
		BeanUtil.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<LinkModel> models = linkDao.findByAllWithHQLQuery();
		assertNotNull(models);
	};

}
