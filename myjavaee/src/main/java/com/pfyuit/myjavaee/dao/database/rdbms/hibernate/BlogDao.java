package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Blog Dao interface for Hibernate.
 * @author yupengfei
 */
public interface BlogDao {

	public abstract void save(BlogModel model);

	public abstract void delete(BlogModel model);

	public abstract void update(BlogModel model);

	public abstract BlogModel findById(int blogId);

	public abstract List<BlogModel> findAll();

}