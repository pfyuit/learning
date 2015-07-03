package com.pfyuit.myjavaee.service;

import com.pfyuit.myjavaee.dto.BlogDto;

public interface BlogService {

	public BlogDto getBlogByMyBatis(Integer blogId);

	public BlogDto getBlogByHibernate(Integer blogId);

}
