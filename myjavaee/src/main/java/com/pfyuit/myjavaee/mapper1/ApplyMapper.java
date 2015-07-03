package com.pfyuit.myjavaee.mapper1;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pfyuit.myjavaee.model.Apply;

public interface ApplyMapper {
	
	@Select("SELECT * FROM apply WHERE apply_id=#{applyId}")
	public Apply getApply(@Param("applyId") Integer applyId);
	
}
