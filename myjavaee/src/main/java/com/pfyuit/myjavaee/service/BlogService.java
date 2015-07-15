package com.pfyuit.myjavaee.service;

import java.util.List;

import com.pfyuit.myjavaee.model.BlogModel;

public interface BlogService {

	public abstract void save(BlogModel model);

	public abstract void delete(BlogModel model);

	public abstract void update(BlogModel model);

	public abstract BlogModel findById(int blogId);

	public abstract List<BlogModel> findAll();

}
