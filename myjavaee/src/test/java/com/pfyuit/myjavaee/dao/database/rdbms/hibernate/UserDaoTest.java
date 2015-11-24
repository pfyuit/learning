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

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.UserModel;

/**
 * The transaction is rolled back by default when setting
 * "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/hibernate/myjavaee-database-rdbms-hibernate-test.xml" })
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
		userDao.save(model);
	};

	@Test
	public void testDelete() {
		UserModel model = userDao.findById(1);
		userDao.delete(model);
	};

	@Test
	public void testUpdate() {
		UserModel model = userDao.findById(1);
		model.setUserName("Updated User Name");
		model.setUserPassword("Updated User Password");
		model.setUserNotes("Updated User Notes");
		userDao.update(model);
	};

	@Test
	public void testFindById() {
		UserModel model = userDao.findById(1);
		assertNotNull(model);
		BlogDaoTest.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<UserModel> models = userDao.findAll();
		assertNotNull(models);
	};

}
