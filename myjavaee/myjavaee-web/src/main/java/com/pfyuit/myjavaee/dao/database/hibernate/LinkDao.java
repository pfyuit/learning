package com.pfyuit.myjavaee.dao.database.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.database.hibernate.LinkModel;

/**
 * Link dao interface for hibernate.
 * @author yupengfei
 */
public interface LinkDao {

	public void saveWithSession(LinkModel model);

	public void deleteWithSession(LinkModel model);

	public void deleteWithHQLQuery(int linkId);

	public void deleteWithSQLQuery(int linkId);

	public void updateWithSession(LinkModel model);

	public void updateWithHQLQuery(int linkId);

	public void updateWithSQLQuery(int linkId);

	public LinkModel findByIdWithSession(int linkId);

	public LinkModel findByIdWithHQLQuery(int linkId);

	public LinkModel findByIdWithSQLQuery(int linkId);

	public LinkModel findByIdWithCriteria(int linkId);

	public List<LinkModel> findByAllWithHQLQuery();

	public List<LinkModel> findByAllWithSQLQuery();

	public List<LinkModel> findByAllWithCriteria();

}