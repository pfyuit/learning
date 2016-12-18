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

import com.pfyuit.myjavaee.model.database.hibernate.UserModel;

/**
 * User dao implement for hibernate.
 * @author yupengfei
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void saveWithSession(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void deleteWithSession(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void deleteWithHQLQuery(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM UserModel WHERE userId=:userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

	@Override
	public void deleteWithSQLQuery(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "DELETE FROM user WHERE user_id=:userId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSession(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void updateWithHQLQuery(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE UserModel SET userName=:userName WHERE userId=:userId";
		Query query = session.createQuery(hql);
		query.setParameter("userName", "newUserTitle");
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSQLQuery(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "UPDATE user SET user_name=:userName WHERE user_id=:userId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("userName", "newUserTitle");
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

	@Override
	public UserModel findByIdWithSession(int userId) {
		Session session = sessionFactory.getCurrentSession();
		UserModel result = (UserModel) session.get(UserModel.class, userId);
		return result;
	}

	@Override
	public UserModel findByIdWithHQLQuery(int userId) {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserModel WHERE userId=:userId");
		query.setParameter("userId", userId);
		UserModel result = (UserModel) query.uniqueResult();

		// Query partial properties from model.
		query = session.createQuery("SELECT new UserModel(userName,userPassword) FROM UserModel WHERE userId=:userId");
		query.setParameter("userId", userId);
		result = (UserModel) query.uniqueResult();
		return result;
	}

	@Override
	public UserModel findByIdWithSQLQuery(int userId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE user_id=:userId");
		query.setParameter("userId", userId);
		UserModel result = (UserModel) query.uniqueResult();
		return result;
	}

	@Override
	public UserModel findByIdWithCriteria(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserModel.class);
		cr.add(Restrictions.eq("userId", userId));
		cr.add(Restrictions.isNotNull("userName"));
		cr.add(Restrictions.in("userName", new String[] { "abc", "def" }));
		cr.addOrder(Order.asc("userId"));
		cr.addOrder(Order.desc("userName"));
		UserModel result = (UserModel) cr.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> findByAllWithHQLQuery() {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserModel");
		List<UserModel> result = query.list();

		// Query partial properties from model.
		query = session.createQuery("SELECT new UserModel(userName,userPassword) FROM UserModel");
		result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> findByAllWithSQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM user");
		List<UserModel> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> findByAllWithCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserModel.class);
		cr.addOrder(Order.asc("userId"));
		cr.addOrder(Order.desc("userName"));
		List<UserModel> result = cr.list();
		return result;
	}

}
