package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.LinkModel;

/**
 * Link Dao implement for Hibernate.
 * @author yupengfei
 */
@Repository
public class LinkDaoImpl implements LinkDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void save(LinkModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void delete(LinkModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void update(LinkModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public LinkModel findById(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		LinkModel result = (LinkModel) session.get(LinkModel.class, linkId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LinkModel> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM LinkModel");
		List<LinkModel> result = query.list();
		return result;
	}

}
