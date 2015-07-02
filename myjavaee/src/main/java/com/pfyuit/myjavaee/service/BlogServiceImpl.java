package com.pfyuit.myjavaee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dto.BlogDto;
import com.pfyuit.myjavaee.dto.BlogDtoBuilder;
import com.pfyuit.myjavaee.mapper.BlogMapper;
import com.pfyuit.myjavaee.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;

	@Override
	@Transactional(value = "master", readOnly = true)
	public BlogDto getBlog(Integer blogId) {
		Blog blog = blogMapper.getBlog(blogId);
		return BlogDtoBuilder.buildBlogDto(blog);
	}

}
