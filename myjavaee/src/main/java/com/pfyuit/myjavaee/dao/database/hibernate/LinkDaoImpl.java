package com.pfyuit.myjavaee.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.hibernate.LinkModel;

/**
 * Link dao implement for hibernate.
 * @author yupengfei
 */
@Repository
public class LinkDaoImpl implements LinkDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void saveWithSession(LinkModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void deleteWithSession(LinkModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void deleteWithHQLQuery(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM LinkModel WHERE linkId=:linkId";
		Query query = session.createQuery(hql);
		query.setParameter("linkId", linkId);
		query.executeUpdate();
	}

	@Override
	public void deleteWithSQLQuery(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "DELETE FROM link WHERE link_id=:linkId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("linkId", linkId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSession(LinkModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void updateWithHQLQuery(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE LinkModel SET linkName=:linkName WHERE linkId=:linkId";
		Query query = session.createQuery(hql);
		query.setParameter("linkName", "newLinkName");
		query.setParameter("linkId", linkId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSQLQuery(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "UPDATE link SET link_name=:linkName WHERE link_id=:linkId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("linkName", "newLinkName");
		query.setParameter("linkId", linkId);
		query.executeUpdate();
	}

	@Override
	public LinkModel findByIdWithSession(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		LinkModel result = (LinkModel) session.get(LinkModel.class, linkId);
		return result;
	}

	@Override
	public LinkModel findByIdWithHQLQuery(int linkId) {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM LinkModel WHERE linkId=:linkId");
		query.setParameter("linkId", linkId);
		LinkModel result = (LinkModel) query.uniqueResult();

		// Query partial properties from model.
		query = session.createQuery("SELECT new LinkModel(linkName,linkUrl) FROM LinkModel WHERE linkId=:linkId");
		query.setParameter("linkId", linkId);
		result = (LinkModel) query.uniqueResult();
		return result;
	}

	@Override
	public LinkModel findByIdWithSQLQuery(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM link WHERE link_id=:linkId");
		query.setParameter("linkId", linkId);
		LinkModel result = (LinkModel) query.uniqueResult();
		return result;
	}

	@Override
	public LinkModel findByIdWithCriteria(int linkId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(LinkModel.class);
		cr.add(Restrictions.eq("linkId", linkId));
		cr.add(Restrictions.isNotNull("linkName"));
		cr.add(Restrictions.in("linkName", new String[] { "abc", "def" }));
		cr.addOrder(Order.asc("linkId"));
		cr.addOrder(Order.desc("linkName"));
		LinkModel result = (LinkModel) cr.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LinkModel> findByAllWithHQLQuery() {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM LinkModel");
		List<LinkModel> result = query.list();

		// Query partial properties from model.
		query = session.createQuery("SELECT new LinkModel(linkName,linkUrl) FROM LinkModel");
		result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LinkModel> findByAllWithSQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM link");
		List<LinkModel> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LinkModel> findByAllWithCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(LinkModel.class);
		cr.addOrder(Order.asc("linkId"));
		cr.addOrder(Order.desc("linkTitle"));
		List<LinkModel> result = cr.list();
		return result;
	}
}
