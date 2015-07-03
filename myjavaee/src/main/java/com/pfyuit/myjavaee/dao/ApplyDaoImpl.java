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
	public void save(ApplyModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void delete(ApplyModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public void update(ApplyModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	public ApplyModel find(int id) {
		Session session = sessionFactory.getCurrentSession();
		ApplyModel result = (ApplyModel) session.get(ApplyModel.class, id);
		return result;
	}

	@Override
	public List<ApplyModel> findApplyByUser(int uid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Apply where ownerId = :ownerId");
		query.setParameter("ownerId", uid);
		@SuppressWarnings("unchecked")
		List<ApplyModel> result = query.list();
		return result;
	}

	@Override
	public List<ApplyModel> findApplyByActivity(int activityId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Apply where activityId = :activityId");
		query.setParameter("activityId", activityId);
		@SuppressWarnings("unchecked")
		List<ApplyModel> result = query.list();
		return result;
	}
}
