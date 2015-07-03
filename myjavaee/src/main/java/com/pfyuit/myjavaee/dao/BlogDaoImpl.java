package com.pfyuit.myjavaee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pfyuit.myjavaee.model.BlogModel;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	@Qualifier("sessionFactoryMyblog")
	private SessionFactory sessionFactory;

	public void save(BlogModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	public void delete(BlogModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	public void update(BlogModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	public BlogModel find(int id) {
		Session session = sessionFactory.getCurrentSession();
		BlogModel result = (BlogModel) session.get(BlogModel.class, id);
		return result;
	}

	@Override
	public List<BlogModel> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blog");
		@SuppressWarnings("unchecked")
		List<BlogModel> result = query.list();
		return result;
	}
}
