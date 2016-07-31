package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Blog Dao interface for Hibernate.
 * @author yupengfei
 */
public interface BlogDao {

	public void saveWithSession(BlogModel model);

	public void deleteWithSession(BlogModel model);

	public void updateWithSession(BlogModel model);

	public BlogModel findByIdWithSession(int blogId);

	public BlogModel findByIdWithHQLQuery(int blogId);

	public BlogModel findByIdWithSQLQuery(int blogId);
	
	public BlogModel findByIdWithCriteria(int blogId);

	public List<BlogModel> findByAllWithHQLQuery();

	public List<BlogModel> findByAllWithSQLQuery();

}