package com.pfyuit.myjavaee.dao.database.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.hibernate.BlogInfo;
import com.pfyuit.myjavaee.model.database.hibernate.BlogModel;

/**
 * Blog dao interface for hibernate.
 * @author yupengfei
 */
public interface BlogDao {

	public void saveWithSession(BlogModel model);

	public void deleteWithSession(BlogModel model);

	public void deleteWithHQLQuery(int blogId);

	public void deleteWithSQLQuery(int blogId);

	public void updateWithSession(BlogModel model);

	public void updateWithHQLQuery(int blogId);

	public void updateWithSQLQuery(int blogId);

	public BlogModel findByIdWithSession(int blogId);

	public BlogModel findByIdWithHQLQuery(int blogId);

	public BlogInfo findByIdWithSQLQuery(int blogId);

	public BlogModel findByIdWithCriteria(int blogId);

	public List<BlogModel> findByAllWithHQLQuery();

	public List<BlogInfo> findByAllWithSQLQuery();

	public List<BlogModel> findByAllWithCriteria();

}