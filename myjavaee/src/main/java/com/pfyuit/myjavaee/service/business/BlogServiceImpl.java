package com.pfyuit.myjavaee.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.jpa.BlogDao;
import com.pfyuit.myjavaee.dao.jpa.LinkDao;
import com.pfyuit.myjavaee.model.jpa.BlogModel;
import com.pfyuit.myjavaee.model.jpa.LinkModel;

@Service
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

	@Override
	@Transactional(value = "myblog")
	public void multiSave() {
		BlogModel model = new BlogModel();
		model.setAuthor("pfyuit");
		blogDao.save(model);

		LinkModel model1 = new LinkModel();
		model1.setName("link");
		model1.setUrl("url");
		throw new RuntimeException("");
	}

	@Override
	@Transactional(value = "myblog")
	public void multiDelete() {
		BlogModel model = blogDao.findById(3);
		blogDao.delete(model);

		LinkModel model1 = linkDao.findById(1);
		throw new RuntimeException("");
	}

	@Override
	@Transactional(value = "myblog")
	public void multiUpdate() {
		BlogModel model = blogDao.findById(3);
		model.setTitle("hello");
		blogDao.update(model);

		LinkModel model1 = linkDao.findById(1);
		throw new RuntimeException("");
	}

	@Override
	@Transactional(value = "myblog", readOnly = true)
	public void multiFindById() {
		BlogModel model = blogDao.findById(3);
		LinkModel model1 = linkDao.findById(1);
	}

}
