package com.pfyuit.myjavaee.service;

import java.util.List;

import com.pfyuit.myjavaee.model.Apply;

public interface ApplyService {

	public abstract void save(Apply model);

	public abstract void delete(Apply model);

	public abstract void update(Apply model);

	public abstract Apply findById(int applyId);

	public abstract List<Apply> findByOwnerId(int ownerId);

	public abstract List<Apply> findByActivityId(int activityId);

}