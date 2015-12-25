package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Blog Dao interface for Hibernate.
 * @author yupengfei
 */
public interface BlogDao {

	public void save(BlogModel model);

	public void delete(BlogModel model);

	public void update(BlogModel model);

	public BlogModel findById(int blogId);

	public List<BlogModel> findAll();

}