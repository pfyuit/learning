package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

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

	@Override
	public void saveWithSession(CommentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void deleteWithSession(CommentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void deleteWithHQLQuery(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM CommentModel WHERE commentId=:commentId";
		Query query = session.createQuery(hql);
		query.setParameter("commentId", commentId);
		query.executeUpdate();
	}

	@Override
	public void deleteWithSQLQuery(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "DELETE FROM comment WHERE comment_id=:commentId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("commentId", commentId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSession(CommentModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void updateWithHQLQuery(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE CommentModel SET commentAuthor=:commentAuthor WHERE commentId=:commentId";
		Query query = session.createQuery(hql);
		query.setParameter("commentAuthor", "newCommentAuthor");
		query.setParameter("commentId", commentId);
		query.executeUpdate();
	}

	@Override
	public void updateWithSQLQuery(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "UPDATE comment SET comment_author=:commentAuthor WHERE comment_id=:commentId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("commentAuthor", "newCommentAuthor");
		query.setParameter("commentId", commentId);
		query.executeUpdate();
	}

	@Override
	public CommentModel findByIdWithSession(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		CommentModel result = (CommentModel) session.get(CommentModel.class, commentId);
		return result;
	}

	@Override
	public CommentModel findByIdWithHQLQuery(int commentId) {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CommentModel WHERE commentId=:commentId");
		query.setParameter("commentId", commentId);
		CommentModel result = (CommentModel) query.uniqueResult();

		// Query partial properties from model.
		query = session.createQuery("SELECT new CommentModel(commentContent,commentAuthor) FROM CommentModel WHERE commentId=:commentId");
		query.setParameter("commentId", commentId);
		result = (CommentModel) query.uniqueResult();
		return result;
	}

	@Override
	public CommentModel findByIdWithSQLQuery(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM comment WHERE comment_id=:commentId");
		query.setParameter("commentId", commentId);
		CommentModel result = (CommentModel) query.uniqueResult();
		return result;
	}

	@Override
	public CommentModel findByIdWithCriteria(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(CommentModel.class);
		cr.add(Restrictions.eq("commentId", commentId));
		cr.add(Restrictions.isNotNull("commentTitle"));
		cr.add(Restrictions.in("commentTitle", new String[] { "abc", "def" }));
		cr.addOrder(Order.asc("commentId"));
		cr.addOrder(Order.desc("commentTitle"));
		CommentModel result = (CommentModel) cr.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentModel> findByAllWithHQLQuery() {
		// Query all properties from model.
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CommentModel");
		List<CommentModel> result = query.list();

		// Query partial properties from model.
		query = session.createQuery("SELECT new CommentModel(commentContent,commentAuthor) FROM CommentModel");
		result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentModel> findByAllWithSQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM comment");
		List<CommentModel> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentModel> findByAllWithCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(CommentModel.class);
		cr.addOrder(Order.asc("commentId"));
		cr.addOrder(Order.desc("commentTitle"));
		List<CommentModel> result = cr.list();
		return result;
	}

}
