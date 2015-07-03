package com.pfyuit.myjavaee.dto;

import com.pfyuit.myjavaee.model.Blog;
import com.pfyuit.myjavaee.model.BlogModel;

public class BlogDtoBuilder {

	public static BlogDto buildBlogDto(Blog blog) {
		BlogDto dto = new BlogDto();
		dto.setAuthor(blog.getAuthor());
		dto.setBlogid(blog.getBlogid());
		dto.setCategoryid(blog.getCategoryid());
		// TODO
		return dto;
	}

	public static BlogDto buildBlogDto(BlogModel blog) {
		BlogDto dto = new BlogDto();
		dto.setAuthor(blog.getAuthor());
		dto.setBlogid(blog.getBlogid());
		dto.setCategoryid(blog.getCategory().getCategoryid());
		// TODO
		return dto;
	}

}
