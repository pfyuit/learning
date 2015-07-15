package com.pfyuit.myjavaee.service;

import java.util.List;

import com.pfyuit.myjavaee.model.Blog;
import com.pfyuit.myjavaee.model.BlogModel;

public interface BlogService {

	public abstract void saveByHibernate(BlogModel model);

	public abstract void deleteByHibernate(BlogModel model);

	public abstract void updateByHibernate(BlogModel model);

	public abstract BlogModel findByIdByHibernate(int blogId);

	public abstract List<BlogModel> findAllByHibernate();

	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	public abstract void saveByMyBatis(Blog model);

	public abstract void deleteByMyBatis(Blog model);

	public abstract void updateByMyBatis(Blog model);

	public abstract Blog findByIdByMyBatis(int blogId);

	public abstract List<Blog> findAllByMyBatis();

}
