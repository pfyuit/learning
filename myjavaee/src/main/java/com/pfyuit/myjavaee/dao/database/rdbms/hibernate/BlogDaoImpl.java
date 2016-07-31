package com.pfyuit.myjavaee.dao.database.rdbms.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;

/**
 * Blog Dao implement for Hibernate.
 * @author yupengfei
 */
@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	@Override
	public void saveWithSession(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void deleteWithSession(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public void updateWithSession(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public BlogModel findByIdWithSession(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		BlogModel result = (BlogModel) session.get(BlogModel.class, blogId);
		return result;
	}

	@Override
	public BlogModel findByIdWithHQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM BlogModel WHERE blogId=:blogId");
		query.setParameter("blogId", blogId);
		BlogModel result = (BlogModel) query.uniqueResult();
		return result;
	}

	@Override
	public BlogModel findByIdWithSQLQuery(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM blog WHERE blog_id=:blogId");
		query.setParameter("blogId", blogId);
		BlogModel result = (BlogModel) query.uniqueResult();
		return result;
	}

	@Override
	public BlogModel findByIdWithCriteria(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(BlogModel.class);
		cr.add(Restrictions.eq("blogId", blogId));
		BlogModel result = (BlogModel) cr.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findByAllWithHQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM BlogModel");
		List<BlogModel> result = query.list();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findByAllWithSQLQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM blog");
		List<BlogModel> result = query.list();
		return result;
	}

	public List<BlogModel> findByAllWithCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(BlogModel.class);
		List<BlogModel> result = cri.list();
		return result;
	}

}
