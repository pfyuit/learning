package com.pfyuit.myjavaee.dao.database.jpa;

import java.util.List;

import com.pfyuit.myjavaee.model.database.jpa.LinkModel;

/**
 * Link dao interface for JPA.
 * @author yupengfei
 */
public interface LinkDao {

	public void save(LinkModel model);

	public void delete(LinkModel model);

	public void update(LinkModel model);

	public LinkModel findById(int linkId);

	public LinkModel findByIdByNamedQuery(int linkId);

	public LinkModel findByIdByNativeQuery(int linkId);

	public List<LinkModel> findAll();

	public List<LinkModel> findAllByNamedQuery();

}