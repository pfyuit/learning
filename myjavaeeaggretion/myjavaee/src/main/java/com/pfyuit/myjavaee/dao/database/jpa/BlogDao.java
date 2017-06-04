package com.pfyuit.myjavaee.dao.database.jpa;

import java.util.List;

import com.pfyuit.myjavaee.model.database.jpa.BlogModel;

/**
 * Blog dao interface for JPA.
 * @author yupengfei
 */
public interface BlogDao {

	public void save(BlogModel model);

	public void delete(BlogModel model);

	public void update(BlogModel model);

	public BlogModel findById(int blogId);

	public BlogModel findByIdByNamedQuery(int blogId);

	public BlogModel findByIdByNativeQuery(int blogId);

	public List<BlogModel> findAll();

	public List<BlogModel> findAllByNamedQuery();

}