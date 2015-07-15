package com.pfyuit.myjavaee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.ApplyModel;

@Repository
public class ApplyDaoImpl implements ApplyDao {

	@Autowired
	@Qualifier("sessionFactoryPinche")
	private SessionFactory sessionFactory;

	@Override
	public void save(ApplyModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void delete(ApplyModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void update(ApplyModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public ApplyModel findById(int applyId) {
		Session session = sessionFactory.getCurrentSession();
		ApplyModel result = (ApplyModel) session.get(ApplyModel.class, applyId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApplyModel> findByOwnerId(int ownerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ApplyModel where ownerId = :ownerId");
		query.setParameter("ownerId", ownerId);
		List<ApplyModel> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApplyModel> findByActivityId(int activityId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ApplyModel where activityId = :activityId");
		query.setParameter("activityId", activityId);
		List<ApplyModel> result = query.list();
		return result;
	}
}
