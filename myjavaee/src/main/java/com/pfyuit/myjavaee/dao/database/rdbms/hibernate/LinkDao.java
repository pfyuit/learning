package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.LinkModel;

/**
 * Link Dao interface for Hibernate.
 * @author yupengfei
 */
public interface LinkDao {

	public abstract void save(LinkModel model);

	public abstract void delete(LinkModel model);

	public abstract void update(LinkModel model);

	public abstract LinkModel findById(int linkId);

	public abstract List<LinkModel> findAll();

}