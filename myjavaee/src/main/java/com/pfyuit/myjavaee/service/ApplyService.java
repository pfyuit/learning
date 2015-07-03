package com.pfyuit.myjavaee.service;

import com.pfyuit.myjavaee.model.Apply;
import com.pfyuit.myjavaee.model.ApplyModel;

public interface ApplyService {

	public abstract ApplyModel getApplyByHibernate(int applyId);

	public abstract Apply getApplyByMyBatis(int applyId);

}