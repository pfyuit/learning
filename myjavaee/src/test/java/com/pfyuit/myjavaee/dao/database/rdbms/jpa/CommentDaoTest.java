package com.pfyuit.myjavaee.dao.database.rdbms.jpa;

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

import com.pfyuit.myjavaee.model.database.rdbms.jpa.BlogModel;
import com.pfyuit.myjavaee.model.database.rdbms.jpa.CommentModel;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/jpa/myjavaee-database-rdbms-jpa-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblogJpa", defaultRollback = true)
@Transactional
public class CommentDaoTest {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private BlogDao blogDao;

	@Test
	public void testSave() {
		BlogModel blog = blogDao.findById(3);

		CommentModel model = new CommentModel();
		model.setCommentAuthor("Example Comment Author");
		model.setCommentContent("Example Comment Content");
		model.setCreateTime(new Timestamp(new Date().getTime()));
		model.setBlog(blog);
		commentDao.save(model);
	};

	@Test
	public void testDelete() {
		CommentModel model = commentDao.findById(3994);
		commentDao.delete(model);
	};

	@Test
	public void testUpdate() {
		CommentModel model = commentDao.findById(3994);
		model.setCommentAuthor("Updated Comment Author");
		model.setCommentContent("Updated Comment Content");
		model.setCreateTime(new Timestamp(new Date().getTime()));
		commentDao.update(model);
	};

	@Test
	public void testFindById() {
		CommentModel model = commentDao.findById(3994);
		assertNotNull(model);
		assertNotNull(model.getBlog());
		BlogDaoTest.printModel(model);
		BlogDaoTest.printModel(model.getBlog());
	};

	@Test
	public void testFindByIdByNamedQuery() {
		CommentModel model = commentDao.findByIdByNamedQuery(3994);
		assertNotNull(model);
		assertNotNull(model.getBlog());
		BlogDaoTest.printModel(model);
		BlogDaoTest.printModel(model.getBlog());
	};

	@Test
	public void testFindByIdByNativeQuery() {
		CommentModel model = commentDao.findByIdByNativeQuery(3994);
		assertNotNull(model);
		BlogDaoTest.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<CommentModel> models = commentDao.findAll();
		assertNotNull(models);
	};

	@Test
	public void testFindAllByNamedQuery() {
		List<CommentModel> models = commentDao.findAllByNamedQuery();
		assertNotNull(models);
	};

}
