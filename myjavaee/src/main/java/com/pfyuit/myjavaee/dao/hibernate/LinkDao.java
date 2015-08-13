package com.pfyuit.myjavaee.dao.hibernate;

import com.pfyuit.myjavaee.model.jpa.LinkModel;

public interface LinkDao {

	public abstract void save(LinkModel model);

	public abstract void delete(LinkModel model);

	public abstract void update(LinkModel model);

	public abstract LinkModel findById(int linkId);

}