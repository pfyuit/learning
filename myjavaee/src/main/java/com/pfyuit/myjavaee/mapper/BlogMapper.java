package com.pfyuit.myjavaee.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.pfyuit.myjavaee.model.Blog;

@Component
public interface BlogMapper {

	@Select("SELECT * FROM blog WHERE blogid=#{blogId}")
	public Blog getBlog(@Param("blogId") Integer blogId);

}
