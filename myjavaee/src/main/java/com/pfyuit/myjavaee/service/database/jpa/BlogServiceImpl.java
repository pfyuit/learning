package com.pfyuit.myjavaee.service.database.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.database.jpa.BlogDao;
import com.pfyuit.myjavaee.model.database.jpa.BlogModel;

/**
 * Database service implement for JPA, including transactions.
 * @author yupengfei
 */
@Service
@Transactional(value = "myblogJpa")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Override
	@Transactional(value = "myblogJpa")
	public void save(BlogModel model) {
		blogDao.save(model);
	}

	@Override
	@Transactional(value = "myblogJpa")
	public void delete(BlogModel model) {
		blogDao.delete(model);
	}

	@Override
	@Transactional(value = "myblogJpa")
	public void update(BlogModel model) {
		blogDao.update(model);
	}

	@Override
	@Transactional(value = "myblogJpa", readOnly = true)
	public BlogModel findById(int blogId) {
		BlogModel model = blogDao.findById(blogId);
		return model;
	}

	@Override
	@Transactional(value = "myblogJpa", readOnly = true)
	public List<BlogModel> findAll() {
		List<BlogModel> models = blogDao.findAll();
		return models;
	}

}
