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

import com.pfyuit.myjavaee.dao.database.hibernate.UserDao;
import com.pfyuit.myjavaee.model.database.hibernate.UserModel;
import com.pfyuit.myjavaee.util.BeanUtil;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/hibernate/myjavaee-database-hibernate-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSave() {
		UserModel model = new UserModel();
		model.setUserName("Example User Name");
		model.setUserPassword("Example User Password");
		model.setUserNotes("Example User Notes");
		userDao.saveWithSession(model);
	};

	@Test
	public void testDelete() {
		UserModel model = userDao.findByIdWithSession(1);
		userDao.deleteWithSession(model);
	};

	@Test
	public void testUpdate() {
		UserModel model = userDao.findByIdWithSession(1);
		model.setUserName("Updated User Name");
		model.setUserPassword("Updated User Password");
		model.setUserNotes("Updated User Notes");
		userDao.updateWithSession(model);
	};

	@Test
	public void testFindById() {
		UserModel model = userDao.findByIdWithSession(1);
		assertNotNull(model);
		BeanUtil.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<UserModel> models = userDao.findByAllWithHQLQuery();
		assertNotNull(models);
	};

}
