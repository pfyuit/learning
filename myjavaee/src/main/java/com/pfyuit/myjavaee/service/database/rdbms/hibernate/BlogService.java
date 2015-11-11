package com.pfyuit.myjavaee.service.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Database service interface for Hibernate, including transactions.
 * @author yupengfei
 */
public interface BlogService {

	public abstract void save(BlogModel model);

	public abstract void delete(BlogModel model);

	public abstract void update(BlogModel model);

	public abstract BlogModel findById(int blogId);

	public abstract List<BlogModel> findAll();

	public abstract void multiSave();

	public abstract void multiDelete();

	public abstract void multiUpdate();

	public abstract void multiFindById();

}
