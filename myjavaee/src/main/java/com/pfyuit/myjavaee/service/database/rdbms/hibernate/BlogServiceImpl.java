package com.pfyuit.myjavaee.service.database.rdbms.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.database.rdbms.hibernate.BlogDao;
import com.pfyuit.myjavaee.dao.database.rdbms.hibernate.LinkDao;
import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Database service implement for Hibernate, including transactions.
 * @author yupengfei
 */
@Service
@Transactional(value = "myblog")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private LinkDao linkDao;

	@Override
	@Transactional(value = "myblog")
	public void save(BlogModel model) {
		blogDao.save(model);
	}

	@Override
	@Transactional(value = "myblog")
	public void delete(BlogModel model) {
		blogDao.delete(model);
	}

	@Override
	@Transactional(value = "myblog")
	public void update(BlogModel model) {
		blogDao.update(model);
	}

	@Override
	@Transactional(value = "myblog", readOnly = true)
	public BlogModel findById(int blogId) {
		BlogModel model = blogDao.findById(blogId);
		return model;
	}

	@Override
	@Transactional(value = "myblog", readOnly = true)
	public List<BlogModel> findAll() {
		List<BlogModel> models = blogDao.findAll();
		return models;
	}

}
