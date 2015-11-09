package com.pfyuit.myjavaee.service.database;

import java.util.List;

import com.pfyuit.myjavaee.model.mybatis.Apply;

/**
 * Database service interface for MyBatis, including transactions.
 * @author yupengfei
 */
public interface ApplyService {

	public abstract void save(Apply model);

	public abstract void delete(Apply model);

	public abstract void update(Apply model);

	public abstract Apply findById(int applyId);

	public abstract List<Apply> findByOwnerId(int ownerId);

	public abstract List<Apply> findByActivityId(int activityId);

}