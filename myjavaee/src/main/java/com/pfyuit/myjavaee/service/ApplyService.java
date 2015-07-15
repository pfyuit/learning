package com.pfyuit.myjavaee.service;

import java.util.List;

import com.pfyuit.myjavaee.model.Apply;
import com.pfyuit.myjavaee.model.ApplyModel;

public interface ApplyService {

	public abstract void saveByHibernate(ApplyModel model);

	public abstract void deleteByHibernate(ApplyModel model);

	public abstract void updateByHibernate(ApplyModel model);

	public abstract ApplyModel findByIdByHibernate(int applyId);

	public abstract List<ApplyModel> findByOwnerIdByHibernate(int ownerId);

	public abstract List<ApplyModel> findByActivityIdByHibernate(int activityId);

	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	public abstract void saveByMyBatis(Apply model);

	public abstract void deleteByMyBatis(Apply model);

	public abstract void updateByMyBatis(Apply model);

	public abstract Apply findByIdByMyBatis(int applyId);

	public abstract List<Apply> findByOwnerIdByMyBatis(int ownerId);

	public abstract List<Apply> findByActivityIdByMyBatis(int activityId);

}