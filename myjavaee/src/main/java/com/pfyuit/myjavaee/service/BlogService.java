package com.pfyuit.myjavaee.service;

import java.util.List;

import com.pfyuit.myjavaee.dto.BlogDto;
import com.pfyuit.myjavaee.model.Blog;

public interface BlogService {

	public BlogDto getBlogByMyBatis(Integer blogId);

	public BlogDto getBlogByHibernate(Integer blogId);

	public List<Blog> getAllBlogByMyBatis();

}
