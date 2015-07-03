package com.pfyuit.myjavaee.dao;

import java.util.List;

import com.pfyuit.myjavaee.model.BlogModel;

public interface BlogDao {

	public abstract void save(BlogModel t);

	public abstract void delete(BlogModel t);

	public abstract void update(BlogModel t);

	public abstract BlogModel find(int id);

	public List<BlogModel> findAll();

}