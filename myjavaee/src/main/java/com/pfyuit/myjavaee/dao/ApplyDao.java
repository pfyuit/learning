package com.pfyuit.myjavaee.dao;

import java.util.List;

import com.pfyuit.myjavaee.model.ApplyModel;

public interface ApplyDao {

	public abstract void save(ApplyModel model);

	public abstract void delete(ApplyModel model);

	public abstract void update(ApplyModel model);

	public abstract ApplyModel findById(int applyId);

	public abstract List<ApplyModel> findByOwnerId(int ownerId);

	public abstract List<ApplyModel> findByActivityId(int activityId);

}