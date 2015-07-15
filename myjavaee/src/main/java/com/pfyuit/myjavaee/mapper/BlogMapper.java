package com.pfyuit.myjavaee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.pfyuit.myjavaee.model.Blog;

@Component
public interface BlogMapper {

	@Insert("INSERT INTO blog(title,author,createDate,lastModified,content,isOriginal,readCount,categoryid) VALUES(#{title},#{author},#{createDate},#{lastModified},#{content},#{isOriginal},#{readCount},#{categoryid})")
	public abstract void save(Blog model);

	@Delete("DELETE FROM blog WHERE blogid=#{blogid}")
	public abstract void delete(Blog model);

	@Update("UPDATE blog SET title=#{title},author=#{author},createDate=#{createDate},lastModified=#{lastModified},content=#{content},isOriginal=#{isOriginal},readCount=#{readCount},categoryid=#{categoryid}  WHERE blogid=#{blogid}")
	public abstract void update(Blog model);

	@Select("SELECT * FROM blog WHERE blogid=#{blogId}")
	public Blog findById(@Param("blogId") Integer blogId);

	public abstract List<Blog> findAll();

}
