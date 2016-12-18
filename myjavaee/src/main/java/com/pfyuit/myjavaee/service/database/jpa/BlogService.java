package com.pfyuit.myjavaee.service.database.jpa;

import java.util.List;

import com.pfyuit.myjavaee.model.database.jpa.BlogModel;

/**
 * Database service interface for JPA, including transactions.
 * @author yupengfei
 */
public interface BlogService {

	public void save(BlogModel model);

	public void delete(BlogModel model);

	public void update(BlogModel model);

	public BlogModel findById(int blogId);

	public List<BlogModel> findAll();

}
