package com.pfyuit.myjavaee.mapper;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyBatisMyblog", defaultRollback = true)
@Transactional
public class BlogMapperTest {

	@Autowired
	private BlogMapper blogMapper;

	@Test
	public void testSave() {
		Blog model = new Blog();
		model.setAuthor("pfyuit");
		model.setCategoryid(3);
		model.setContent("content");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setIsOriginal("true");
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(0);
		model.setTitle("title");
		blogMapper.save(model);
	};

	@Test(expected = DataIntegrityViolationException.class)
	public void testDelete() {
		Blog model = blogMapper.findById(3);
		blogMapper.delete(model);
	};

	@Test
	public void testUpdate() {
		Blog model = blogMapper.findById(3);
		model.setContent("content");
		blogMapper.update(model);
	};

	@Test
	public void testFindById() {
		Blog model = blogMapper.findById(3);
		assertNotNull(model);
	};

	@Test
	public void testFindAll() {
		List<Blog> models = blogMapper.findAll();
		assertNotNull(models);
	};

}
