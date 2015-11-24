package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.UserModel;

/**
 * User Dao implement for Hibernate.
 * @author yupengfei
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void save(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void delete(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void update(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public UserModel findById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		UserModel result = (UserModel) session.get(UserModel.class, userId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserModel");
		List<UserModel> result = query.list();
		return result;
	}

}
