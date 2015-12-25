package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.LinkModel;

/**
 * Link Dao interface for Hibernate.
 * @author yupengfei
 */
public interface LinkDao {

	public void save(LinkModel model);

	public void delete(LinkModel model);

	public void update(LinkModel model);

	public LinkModel findById(int linkId);

	public List<LinkModel> findAll();

}