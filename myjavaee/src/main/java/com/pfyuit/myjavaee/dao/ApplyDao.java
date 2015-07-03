package com.pfyuit.myjavaee.dao;

import java.util.List;

import com.pfyuit.myjavaee.model.ApplyModel;

public interface ApplyDao {

	public abstract void save(ApplyModel t);

	public abstract void delete(ApplyModel t);

	public abstract void update(ApplyModel t);

	public abstract ApplyModel find(int id);

	public abstract List<ApplyModel> findApplyByUser(int uid);

	public abstract List<ApplyModel> findApplyByActivity(int activityId);

}