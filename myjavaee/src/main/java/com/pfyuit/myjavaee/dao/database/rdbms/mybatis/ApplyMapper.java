package com.pfyuit.myjavaee.dao.database.rdbms.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pfyuit.myjavaee.model.database.rdbms.mybatis.Apply;

/**
 * Apply Dao interface for MyBatis.
 * <p>
 * It supports both annotation and XML configuration.
 * @author yupengfei
 */
public interface ApplyMapper {

	@Insert("INSERT INTO apply(activity_id,owner_id,status,apply_time,last_modify,owner_name) VALUES(#{activityId},#{ownerId},#{status},#{applyTime},#{lastModify},#{ownerName})")
	public void save(Apply model);

	@Delete("DELETE FROM apply WHERE apply_id=#{applyId}")
	public void delete(Apply model);

	@Update("UPDATE apply SET activity_id=#{activityId},owner_id=#{ownerId},status=#{status},apply_time=#{applyTime},last_modify=#{lastModify},owner_name=#{ownerName} WHERE apply_id=#{applyId}")
	public void update(Apply model);

	@Select("SELECT * FROM apply WHERE apply_id=#{applyId}")
	public Apply findById(@Param("applyId") Integer applyId);

	@Select("SELECT * FROM apply WHERE owner_id=#{applyId}")
	public List<Apply> findByOwnerId(@Param("applyId") int ownerId);

	@Select("SELECT * FROM apply WHERE activity_id=#{activityId}")
	public List<Apply> findByActivityId(@Param("activityId") int activityId);

}
