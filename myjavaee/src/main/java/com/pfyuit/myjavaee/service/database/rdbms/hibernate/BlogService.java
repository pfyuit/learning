package com.pfyuit.myjavaee.service.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Database service interface for Hibernate, including transactions.
 * @author yupengfei
 */
public interface BlogService {

	public void save(BlogModel model);

	public void delete(BlogModel model);

	public void update(BlogModel model);

	public BlogModel findById(int blogId);

	public List<BlogModel> findAll();

}
