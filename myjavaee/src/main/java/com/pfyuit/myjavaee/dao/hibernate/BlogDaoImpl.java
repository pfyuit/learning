package com.pfyuit.myjavaee.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.jpa.BlogModel;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	public void save(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	public void delete(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	public void update(BlogModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	public BlogModel findById(int blogId) {
		Session session = sessionFactory.getCurrentSession();
		BlogModel result = (BlogModel) session.get(BlogModel.class, blogId);
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogModel> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from BlogModel");
		List<BlogModel> result = query.list();
		return result;
	}
}
