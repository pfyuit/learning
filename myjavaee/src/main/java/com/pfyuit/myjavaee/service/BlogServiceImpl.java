package com.pfyuit.myjavaee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.BlogDao;
import com.pfyuit.myjavaee.dto.BlogDto;
import com.pfyuit.myjavaee.dto.BlogDtoBuilder;
import com.pfyuit.myjavaee.mapper.BlogMapper;
import com.pfyuit.myjavaee.model.Blog;
import com.pfyuit.myjavaee.model.BlogModel;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private BlogMapper blogMapper;

	@Override
	@Transactional(value = "hibernate_myblog", readOnly = true)
	public BlogDto getBlogByHibernate(Integer blogId) {
		BlogModel blog = blogDao.findById(blogId);
		return BlogDtoBuilder.buildBlogDto(blog);
	}

	@Override
	@Transactional(value = "mybatis_myblog", readOnly = true)
	public BlogDto getBlogByMyBatis(Integer blogId) {
		Blog blog = blogMapper.findById(blogId);
		return BlogDtoBuilder.buildBlogDto(blog);
	}

}
