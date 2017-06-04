package com.pfyuit.myjavaee.dao.database.jpa;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.database.jpa.BlogDao;
import com.pfyuit.myjavaee.model.database.jpa.BlogModel;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/jpa/myjavaee-database-jpa-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblogJpa", defaultRollback = true)
@Transactional
public class BlogDaoTest {

	@Autowired
	private BlogDao blogDao;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testSave() {
		// CategoryModel category = categoryDao.findById(5);

		BlogModel model = new BlogModel();
		model.setBlogAuthor("Example Blog Author");
		model.setBlogContent("Example Blog Content");
		model.setBlogOriginal("Example Blog Original");
		model.setBlogTitle("Example Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		// model.setCategory(category);
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
	public void testFindByIdByNamedQuery() {
		BlogModel model = blogDao.findByIdByNamedQuery(3);
		assertNotNull(model);
		assertNotNull(model.getComments());
		printModel(model);
	};

	@Test
	public void testFindByIdByNativeQuery() {
		BlogModel model = blogDao.findByIdByNativeQuery(3);
		assertNotNull(model);
		printModel(model);
	};

	@Test
	public void testFindAll() {
		List<BlogModel> models = blogDao.findAll();
		assertNotNull(models);
	};

	@Test
	public void testFindAllByNamedQuery() {
		List<BlogModel> models = blogDao.findAllByNamedQuery();
		assertNotNull(models);
	};

	/**
	 * 对不同状态下的实例A，persist会产生以下操作:
	 * <p>
	 * 1.如果A是一个new状态的实体，它将会转为managed状态；
	 * <p>
	 * 2.如果A是一个managed状态的实体，它的状态不会发生任何改变。但是系统仍会在数据库执行INSERT操作；
	 * <p>
	 * 3.如果A是一个detached(分离)状态的实体，该方法会抛出IllegalArgumentException异常，具体异常根据不同的JPA实现有关
	 * <p>
	 * 4.如果A是一个removed(删除)状态的实体，它将会转换为受控状态；
	 * <p>
	 * Persist: NEW(OK), MANAGED(OK), DETACHED(NOK), REMOVED(OK)
	 */
	@Test
	@Ignore
	public void testEntityPersist() {
		int id = 0;

		// persist a NEW entity without identity
		System.out.println("*******persist a new entity without identity");
		BlogModel model = new BlogModel();
		model.setBlogAuthor("Author");
		model.setBlogContent("Content");
		model.setBlogOriginal("Original");
		model.setBlogTitle("Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		System.out.println("before persist: " + em.contains(model));
		em.persist(model);
		printModel(model);
		System.out.println("after persist: " + em.contains(model));
		id = model.getBlogId();

		// persist a NEW entity with identity, will throw PersistenceException
		System.out.println("*******persist a new entity with identity");
		BlogModel model1 = new BlogModel();
		model1.setBlogId(50);
		model1.setBlogAuthor("Author1");
		model1.setBlogContent("Content1");
		model1.setBlogOriginal("Original1");
		model1.setBlogTitle("Title");
		model1.setCreateDate(new Timestamp(new Date().getTime()));
		model1.setLastModified(new Timestamp(new Date().getTime()));
		model1.setReadCount(new Long(0));
		// System.out.println("before persist: " + em.contains(model1));
		// em.persist(model1);
		// printModel(model1);
		// System.out.println("after persist: " + em.contains(model1));

		// persist a MANAGED entity
		System.out.println("*******persist a managed entity");
		model.setBlogAuthor("AuthorUpdated");
		System.out.println("before persist: " + em.contains(model));
		em.persist(model);// can't persist updated content??
		printModel(model);
		System.out.println("after persist: " + em.contains(model));

		// persist a DETACHED entity, will throw PersistenceException
		System.out.println("*******persist a detached entity");
		em.detach(model);
		model.setBlogAuthor("AuthorUpdated1");
		System.out.println("before persist: " + em.contains(model));
		// em.persist(model);
		// printModel(model);
		// System.out.println("after persist: " + em.contains(model));

		// persist a REMOVED entity
		System.out.println("*******persist a removed entity");
		model = em.find(BlogModel.class, id);
		System.out.println("before remove: " + em.contains(model));
		em.remove(model);
		model.setBlogAuthor("AuthorUpdated2");
		System.out.println("before persist: " + em.contains(model));
		em.persist(model);
		printModel(model);
		System.out.println("after persist: " + em.contains(model));
	}

	/**
	 * 对不同状态下的实例A，merge会产生以下操作:
	 * <p>
	 * 1. 如果A是一个new状态的实体，该方法会产生一个根据A产生的managed状态实体A2;
	 * <p>
	 * 2. 如果A是一个managed状态的实体，它的状态不会发生任何改变。但是系统仍会在数据库执行UPDATE操作；
	 * <p>
	 * 3. 如果A是一个detached状态的实体，该方法会将A的修改提交到数据库，并返回一个新的managed状态的实例A2；
	 * <p>
	 * 4. 如果A是一个removed状态的实体，该方法会抛出IllegalArgumentException异常。
	 * <p>
	 * Merge: NEW(OK), MANAGED(OK), DETACHED(OK), REMOVED(NOK)
	 */
	@Test
	@Ignore
	public void testEntityMerge() {
		int id = 0;

		// merge a NEW entity without identity
		System.out.println("*******merge a new entity without identity");
		BlogModel model = new BlogModel();
		model.setBlogAuthor("Author");
		model.setBlogContent("Content");
		model.setBlogOriginal("Original");
		model.setBlogTitle("Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		System.out.println("before merge: " + em.contains(model));
		BlogModel newModel = em.merge(model);// create a new one, newModel is managed.
		printModel(model);
		System.out.println("after merge: " + em.contains(model));

		// merge a NEW entity with identity
		System.out.println("*******merge a new entity with identity");
		BlogModel model1 = new BlogModel();
		model1.setBlogId(id);
		model1.setBlogAuthor("Author1");
		model1.setBlogContent("Content1");
		model1.setBlogOriginal("Original1");
		model1.setBlogTitle("Title");
		model1.setCreateDate(new Timestamp(new Date().getTime()));
		model1.setLastModified(new Timestamp(new Date().getTime()));
		model1.setReadCount(new Long(0));
		System.out.println("before merge: " + em.contains(model1));
		em.merge(model1);// If exist, update. If not exit, create one.
		printModel(model1);
		System.out.println("after merge: " + em.contains(model1));

		// merge a MANAGED entity
		System.out.println("*******merge a managed entity");
		model = em.find(BlogModel.class, 7);
		model.setBlogAuthor("AuthorUpdated");
		System.out.println("before merge: " + em.contains(model));
		em.merge(model);
		printModel(model);
		System.out.println("after merge: " + em.contains(model));

		// mrege a DETACHED entity
		System.out.println("*******merge a detached entity");
		em.detach(model);
		model.setBlogAuthor("AuthorUpdated1");
		System.out.println("before merge: " + em.contains(model));
		em.merge(model);
		printModel(model);
		System.out.println("after merge: " + em.contains(model));

		// merge a REMOVED entity, will throw IllegalArgumentException
		System.out.println("*******merge a removed entity");
		model = em.find(BlogModel.class, 72);
		System.out.println("before remove: " + em.contains(model));
		// em.remove(model);
		// model.setBlogAuthor("Updated Blog Author");
		// System.out.println("before merge: " + em.contains(model));
		// em.merge(model);
		// printModel(model);
		// System.out.println(em.contains(model));
	}

	/**
	 * 对不同状态下的实例A，remove会产生以下操作:
	 * <p>
	 * 1. 如果A是一个new状态的实例，A的状态不会发生任何改变，但系统仍会在数据库中执行DELETE语句；
	 * <p>
	 * 2. 如果A是一个managed状态的实例，它的状态会转换为removed；
	 * <p>
	 * 3. 如果A是一个detached状态的实体，该方法将会抛出异常。
	 * <p>
	 * 4. 如果A是一个removed状态的实例，不会发生任何操作;
	 * <p>
	 * Remove: NEW(OK), MANAGED(OK), DETACHED(NOK), REMOVED(OK)
	 */
	@Test
	// @Ignore
	public void testEntityRemove() {
		// remove a NEW entity without identity
		System.out.println("*******remove a new entity without identity");
		BlogModel model = new BlogModel();
		model.setBlogAuthor("Author");
		model.setBlogContent("Content");
		model.setBlogOriginal("Original");
		model.setBlogTitle("Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		System.out.println("before remove: " + em.contains(model));
		em.remove(model);
		printModel(model);
		System.out.println("after remove: " + em.contains(model));

		// remove a NEW entity with identity, will throw IllegalArgumentException
		System.out.println("*******remove a new entity with identity");
		BlogModel model1 = new BlogModel();
		model1.setBlogId(50);
		model1.setBlogAuthor("Author1");
		model1.setBlogContent("Content1");
		model1.setBlogOriginal("Original1");
		model1.setBlogTitle("Title");
		model1.setCreateDate(new Timestamp(new Date().getTime()));
		model1.setLastModified(new Timestamp(new Date().getTime()));
		model1.setReadCount(new Long(0));
		System.out.println("before remove: " + em.contains(model1));
		// em.remove(model1);
		// printModel(model1);
		// System.out.println("after remove: " + em.contains(model1));

		// remove a MANAGED entity
		System.out.println("*******remove a managed entity");
		model = em.find(BlogModel.class, 7);
		model.setBlogAuthor("AuthorUpdated");
		System.out.println("before remove: " + em.contains(model));
		em.remove(model);
		printModel(model);
		System.out.println("after remove: " + em.contains(model));

		// mrege a DETACHED entity, will throw exception.
		System.out.println("*******remove a detached entity");
		em.detach(model);
		model.setBlogAuthor("AuthorUpdated1");
		System.out.println("before remove: " + em.contains(model));
		// em.merge(model);
		// printModel(model);
		// System.out.println("after remove: " + em.contains(model));
	}

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
