package com.pfyuit.myjavaee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.BlogDao;
import com.pfyuit.myjavaee.mapper.BlogMapper;
import com.pfyuit.myjavaee.model.Blog;
import com.pfyuit.myjavaee.model.BlogModel;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private BlogMapper blogMapper;

	@Override
	@Transactional(value = "hibernate_myblog")
	public void saveByHibernate(BlogModel model) {
		blogDao.save(model);
	}

	@Override
	@Transactional(value = "hibernate_myblog")
	public void deleteByHibernate(BlogModel model) {
		blogDao.delete(model);
	}

	@Override
	@Transactional(value = "hibernate_myblog")
	public void updateByHibernate(BlogModel model) {
		blogDao.update(model);
	}

	@Override
	@Transactional(value = "hibernate_myblog", readOnly = true)
	public BlogModel findByIdByHibernate(int blogId) {
		BlogModel model = blogDao.findById(blogId);
		return model;
	}

	@Override
	@Transactional(value = "hibernate_myblog", readOnly = true)
	public List<BlogModel> findAllByHibernate() {
		List<BlogModel> models = blogDao.findAll();
		return models;
	}

	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	@Override
	@Transactional(value = "mybatis_myblog")
	public void saveByMyBatis(Blog model) {
		blogMapper.save(model);
	}

	@Override
	@Transactional(value = "mybatis_myblog")
	public void deleteByMyBatis(Blog model) {
		blogMapper.delete(model);
	}

	@Override
	@Transactional(value = "mybatis_myblog")
	public void updateByMyBatis(Blog model) {
		blogMapper.update(model);
	}

	@Override
	@Transactional(value = "mybatis_myblog", readOnly = true)
	public Blog findByIdByMyBatis(int blogId) {
		Blog model = blogMapper.findById(blogId);
		return model;
	}

	@Override
	@Transactional(value = "mybatis_myblog", readOnly = true)
	public List<Blog> findAllByMyBatis() {
		List<Blog> models = blogMapper.findAll();
		return models;
	}

}
