package com.pfyuit.myjavaee.service.database.mybatis;

import java.util.List;

import com.pfyuit.myjavaee.model.database.mybatis.Apply;

/**
 * Database service interface for MyBatis, including transactions.
 * @author yupengfei
 */
public interface ApplyService {

	public void save(Apply model);

	public void delete(Apply model);

	public void update(Apply model);

	public Apply findById(int applyId);

	public List<Apply> findByOwnerId(int ownerId);

	public List<Apply> findByActivityId(int activityId);

}