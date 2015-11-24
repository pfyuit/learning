package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.CommentModel;

/**
 * Comment Dao implement for Hibernate.
 * @author yupengfei
 */
@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	public void save(CommentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	public void delete(CommentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	public void update(CommentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	public CommentModel findById(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		CommentModel result = (CommentModel) session.get(CommentModel.class, commentId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentModel> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CommentModel");
		List<CommentModel> result = query.list();
		return result;
	}
}
