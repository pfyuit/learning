package com.pfyuit.myjavaee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.BlogDao;
import com.pfyuit.myjavaee.model.BlogModel;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

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
